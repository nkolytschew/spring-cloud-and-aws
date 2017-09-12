package com.github.nkolytschew.aws.core.mvc.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 * @author NKO
 * @version %I%, %G%
 * @since 1.X-SNAPSHOT
 */
@Controller
class RedirectController {

  @GetMapping("/")
  fun getIndex() = "forward:/index.html"

}