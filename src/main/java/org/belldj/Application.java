package org.belldj;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
  info = @Info(
	title = "Test",
    version = "0.1.0",
    description = "My Test MN API",
    license = @License(name = "Apache 2.0", url = "http://foo.bar"),
    contact = @Contact(url = "http://localhost:8080", name = "Bilbo", email = "me@mycompany.com")
  )
)
public class Application {
  public static void main(final String[] args) {
    Micronaut.run(Application.class);
  }
}
