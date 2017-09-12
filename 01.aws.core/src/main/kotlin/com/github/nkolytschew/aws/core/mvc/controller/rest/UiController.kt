package com.github.nkolytschew.aws.core.mvc.controller.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal
import java.util.*

/**
 * @author NKO
 * @version %I%, %G%
 * @since 1.X-SNAPSHOT
 */
@RestController
class UiController {

  @GetMapping("resource")
  fun getHome(): Map<String, String> =
      mutableMapOf(
          Pair("id", UUID.randomUUID().toString()),
          Pair("content", "Hello World"))

  @GetMapping("user")
  fun getUser(user: Principal) = user

}