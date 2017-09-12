package com.github.nkolytschew.aws.core.config.security

import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.csrf.CookieCsrfTokenRepository


/**
 * @author NKO
 * @version %I%, %G%
 * @since 1.0.0-SNAPSHOT
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class SecurityConfiguration : WebSecurityConfigurerAdapter() {
  // @formatter:off
  @Throws(Exception::class)
  override fun configure(http: HttpSecurity) {
    http
        .httpBasic()
      .and()
        .authorizeRequests()
          .antMatchers("/index.html", "/home", "/login", "/").permitAll()
          .anyRequest().authenticated()
      .and()
        .csrf()
          .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
  }
  // @formatter:on
}