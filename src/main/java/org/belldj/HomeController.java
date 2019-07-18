package org.belldj;

import java.security.Principal;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;

@Controller("/")
public class HomeController {

	@Secured("isAuthenticated()")
  @Get("/name")
  public String name(final Principal principal) {  // <4>
      return principal.getName();
  }

	@Secured("isAnonymous()")
  @Get("/hello")
  public String hello() {
      return "Hello World";
  }

}
