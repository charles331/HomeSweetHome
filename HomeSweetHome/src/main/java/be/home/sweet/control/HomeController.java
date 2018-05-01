package be.home.sweet.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	
	@GetMapping("/")
	public String getHuman() {
		return "human";
	}

}
