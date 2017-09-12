package com.github.nkolytschew.aws.core

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
//import org.springframework.cloud.client.SpringCloudApplication


/**
 * use [SpringCloudApplication] annotation, which implies [org.springframework.boot.autoconfigure.SpringBootApplication]
 */
//@SpringCloudApplication
@SpringBootApplication
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}

