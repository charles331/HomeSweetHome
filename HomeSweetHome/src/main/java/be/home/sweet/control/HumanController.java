package be.home.sweet.control;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		mav.addObject("humanProfiles", Human.getProfiles());
		return mav;
	}
	
	@PostMapping("human-create")
	public ModelAndView createHuman(@Valid Human human,  BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			System.out.println("Validation human error " + result.toString());
			mav.setViewName("human-create");
			mav.addObject("human", human);
			mav.addObject("humanProfiles", Human.getProfiles());
			return mav;			
		}
		System.out.println("save human " + human.getFirstName());
		humanRepo.save(human);		
		mav.setViewName("allhumans");
		mav.addObject("humans", humanRepo.findAll());
		return mav;
	}
	
	//https://stackoverflow.com/questions/33498114/spring-data-mvc-thymeleaf-update-entity
	//https://medium.com/@grokwich/spring-boot-thymeleaf-html-form-handling-762ef0d51327
	@GetMapping("human-details/{humanId}")
	public ModelAndView seeHumanDetails(@PathVariable("humanId") Long id) {
		ModelAndView mav = new ModelAndView();		
		Optional<Human> hm = humanRepo.findById(id);
		mav.setViewName("human-details");
		mav.addObject("human", hm);
		return mav;
	}
	
	@GetMapping("human-delete/{humanId}")
	public ModelAndView deleteHumanDetails(@PathVariable("humanId") Long id) {
		ModelAndView mav = new ModelAndView();			
		humanRepo.deleteById(id);
		mav.setViewName("allhumans");
		mav.addObject("humans", humanRepo.findAll());
		return mav;
	}
	
	
}
