package org.example.controller;

import org.example.TrackUserAction;
import org.example.service.AdminService;
import org.example.service.HomeService;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	private final HomeService homeService;
	private final UserService userService;
	private final AdminService adminService;
	
	public HomeController(HomeService homeService, UserService userService, AdminService adminService) {
		this.homeService = homeService;
		this.userService = userService;
		this.adminService = adminService;
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("text", homeService.getText());
		return "index";
	}
	@GetMapping("/private-data")
	public String privateData(Model model) {
		adminService.adminServiceMethod("Admin used privat-data service");
		return "private-data";
	}

	@TrackUserAction
	@GetMapping("/public-data")
	public String publicData(Model model) {
		userService.userServiceMethod("User used public-data service");
		return "public-data";
	}

	@GetMapping("/index")
	public String index() {
		return "redirect:/";
	}
	
	@GetMapping("/user")
	public String user(Model model) {
		model.addAttribute("text", userService.getText());
		return "user";
	}
	
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("text", adminService.getText());
		return "admin";
	}
}
