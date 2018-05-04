package be.home.sweet.control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.home.sweet.entities.Human;
import be.home.sweet.entities.HumanRepository;

@Controller
@RequestMapping("app")
public class HumanController {
	//https://www.concretepage.com/spring-boot/spring-boot-thymeleaf-maven-example
	
	@Autowired
	HumanRepository humanRepo;
	
	@GetMapping("all")
	public ModelAndView seeAllHumans() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("allhumans");
		mav.addObject("humans", humanRepo.findAll());
		return mav;
	}

	@GetMapping("human-create")
	public ModelAndView createHumanView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("human-create");
		System.out.println("Create empty human");
		mav.addObject("human", new Human());
		return mav;
	}
	
	@PostMapping("human-create")
	public ModelAndView createHuman(@Valid Human human,  BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			System.out.println("Validation human error " + result.toString());
			mav.setViewName("human-create");
			mav.addObject("human", human);
			return mav;			
		}
		System.out.println("save human " + human.getFirstName());
		humanRepo.save(human);
		mav.setViewName("allhumans");
		mav.addObject("humans", humanRepo.findAll());
		return mav;
	}
	
}
