package net.robotmodel67.juno.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/resources/auth")
public class UserResource {

	@RequestMapping(path = "")
	public String validateUser() {
		return "{\"status\": \"OK\", \"result\": \"Hello World!\"}";
	}
}
