package com.github.nkolytschew3.aws.core.authserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.springframework.boot.context.embedded.LocalServerPort;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

	@LocalServerPort
	private int port;

	private TestRestTemplate template = new TestRestTemplate();

	@Test
	public void homePageProtected() {
		ResponseEntity<String> response = template.getForEntity("http://localhost:" + port + "/uaa/", String.class);
		assertThat(response.getStatusCode(), is(HttpStatus.UNAUTHORIZED));
		String auth = response.getHeaders().getFirst("WWW-Authenticate");
		assertThat("Wrong header: " + auth, true, is(auth.startsWith("Bearer realm=\"")));
	}

	@Test
	public void userEndpointProtected() {
		ResponseEntity<String> response = template.getForEntity("http://localhost:" + port + "/uaa/user", String.class);
		assertThat(response.getStatusCode(), is(HttpStatus.UNAUTHORIZED));
		String auth = response.getHeaders().getFirst("WWW-Authenticate");
		assertThat("Wrong header: " + auth, true, is(auth.startsWith("Bearer realm=\"")));
	}

	@Test
	public void authorizationRedirects() {
		ResponseEntity<String> response = template.getForEntity("http://localhost:" + port + "/uaa/oauth/authorize", String.class);
		assertThat(response.getStatusCode(), is(HttpStatus.UNAUTHORIZED));
		String auth = response.getHeaders().getFirst("WWW-Authenticate");
		assertThat("Wrong header: " + auth, true, is(auth.startsWith("Basic realm=\"")));
	}

}
