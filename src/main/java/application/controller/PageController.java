package application.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/")
	public String index() {
		System.out.println("PageController.index()");
		return "index";
	
	}
}
	
