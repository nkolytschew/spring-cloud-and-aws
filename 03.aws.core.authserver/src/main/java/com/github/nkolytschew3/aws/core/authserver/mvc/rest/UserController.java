package com.github.nkolytschew3.aws.core.authserver.mvc.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author NKO
 * @version %I%, %G%
 * @since 1.0.0-SNAPSHOT
 */
@RestController
public class UserController {
	@RequestMapping("/user")
	public Principal getUser(final Principal user) {
		return user;
	}
}
