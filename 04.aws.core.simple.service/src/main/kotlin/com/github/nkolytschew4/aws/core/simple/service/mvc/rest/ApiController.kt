package com.github.nkolytschew4.aws.core.simple.service.mvc.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

/**
 * @author NKO
 * @version %I%, %G%
 * @since 1.0.0-SNAPSHOT
 */
@RestController
class ApiController {

  @GetMapping("hello")
  fun getSimpleHello() = ResponseEntity("hello", HttpStatus.OK)

  @GetMapping("hellos")
  fun getSimpleHellos() = ResponseEntity(listOf("he", "ll", "oh"), HttpStatus.OK)

  @GetMapping("something/{different}")
  fun getSomethingDifferent(@PathVariable different: String) = ResponseEntity(different, HttpStatus.OK)

  @GetMapping("user")
  fun getUser(user: Principal) = user
}