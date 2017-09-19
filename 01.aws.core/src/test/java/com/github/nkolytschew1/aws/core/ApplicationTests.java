package com.github.nkolytschew1.aws.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

	@LocalServerPort
	private int port;

	@Value("${security.oauth2.client.userAuthorizationUri}")
	private String authorizeUri;

	private TestRestTemplate template = new TestRestTemplate();

	@Test
	public void homePageLoads() {
		ResponseEntity<String> response = template.getForEntity("http://localhost:" + port + "/", String.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}

	@Test
	public void userEndpointProtected() {
		ResponseEntity<String> response = template.getForEntity("http://localhost:" + port + "/user", String.class);
		assertThat(response.getStatusCode(), is(HttpStatus.FOUND));
	}

	@Test
	public void resourceEndpointProtected() {
		ResponseEntity<String> response = template.getForEntity("http://localhost:" + port + "/resource", String.class);
		assertThat(response.getStatusCode(), is(HttpStatus.FOUND));
	}

	@Test
	public void loginRedirects() {
		ResponseEntity<String> response = template.getForEntity("http://localhost:" + port + "/login", String.class);
		assertThat(response.getStatusCode(), is(HttpStatus.FOUND));
		String location = response.getHeaders().getFirst("Location");
		assertThat("Wrong location: " + location, location.startsWith(authorizeUri), is(true));
	}
}
