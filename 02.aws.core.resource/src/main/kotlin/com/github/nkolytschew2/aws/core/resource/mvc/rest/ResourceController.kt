package com.github.nkolytschew2.aws.core.resource.mvc.rest

import com.github.nkolytschew2.aws.core.resource.mvc.model.ResourceModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author NKO
 * @version %I%, %G%
 * @since 1.0.0-SNAPSHOT
 */
@RequestMapping("api")
@RestController
class ResourceController {

  @GetMapping("resource")
  fun getHome(): ResourceModel = ResourceModel(content = "Hello World")
}