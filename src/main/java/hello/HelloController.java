package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class HelloController {

	@RequestMapping(value = "/hi", method = {POST, GET})
	@ApiImplicitParams({
		@ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query")
	})
	public String index(String name) {
		String msg = "Greetings from my first springboot controller";
		if (name != null && name.length() > 0)
			msg = String.join(", ", msg, name);
		return msg;
	}
}