package haagahelia.BoxingProject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoxingProjectController {

	@GetMapping("/index")
	public String helloWorld() {
		return "index";
	}
}
