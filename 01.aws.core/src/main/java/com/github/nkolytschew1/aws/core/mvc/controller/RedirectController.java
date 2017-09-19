package com.github.nkolytschew1.aws.core.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author NKO
 * @version %I%, %G%
 * @since 1.X-SNAPSHOT
 */
@Controller
public class RedirectController {
	@RequestMapping("/")
	public String getStartPage(){
		return "forward:/index.html";
	}
}
