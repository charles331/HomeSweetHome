package be.home.sweet.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import be.home.sweet.entities.Human;
import be.home.sweet.entities.HumanRepository;

@Controller
public class HomeController {
	
	@Autowired
	HumanRepository humanRepo;
	
	@GetMapping("/")
	public String getHuman(Model model) {
		model.addAttribute("human", new Human());
		return "human";
	}
	
	@PostMapping("/")
	public String addHuman(@ModelAttribute Human human) {
		humanRepo.save(human);
		System.out.println("Save human " + human.toString());
		return "human";
	}
	
	@GetMapping("/allhumans")
	public String getAllHumans(Model model) {
		model.addAttribute("humans", humanRepo.findAll());
		return "allhumans";
		//https://www.concretepage.com/spring-boot/spring-boot-thymeleaf-maven-example
	}

}
