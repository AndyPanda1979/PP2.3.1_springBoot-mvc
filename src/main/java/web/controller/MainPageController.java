package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.UserService;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainPageController {

	final
	UserService userService;

	public MainPageController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("PP2.3.1 Spring-MVC");
		model.addAttribute("messages", messages);
		return "main/index";
	}
}