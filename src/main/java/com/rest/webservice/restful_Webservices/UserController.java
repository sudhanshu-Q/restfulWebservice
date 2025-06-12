package com.rest.webservice.restful_Webservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.rws.course.CourseService;

import registration.UserDetails;
import registration.UserRepository;

@Controller
public class UserController {
	
	@GetMapping("/register")
	public String showForm(Model model) {
		UserDetails userDetails=new UserDetails();
		model.addAttribute("user",userDetails);
		List<String> professionList=Arrays.asList("Tester","Manual","Developer");
		model.addAttribute("professionList",professionList);
		return "registration_form";
	}
	
	@PostMapping("/register")
	public String submitForm(@ModelAttribute("user") UserDetails uDetails) {
//	//	this.userDetails = userDetails;
		System.out.println(uDetails);
//		UserDetails inserted_user= userRepo.save(uDetails);
//		System.out.println(inserted_user);
	
		return "registration_success";
	}

}
