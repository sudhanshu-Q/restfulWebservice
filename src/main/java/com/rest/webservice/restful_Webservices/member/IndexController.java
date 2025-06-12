package com.rest.webservice.restful_Webservices.member;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import registration.UserDetails;

@Controller
public class IndexController {

	@Autowired
	private MemeberRepository memeberRepository;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/newMember")
	public String showForm(Model model) {
		Member member_details=new Member();
		model.addAttribute("user",member_details);
		return "memberForm";
	}
	
	@PostMapping("/newMember")
	public String submitForm(@ModelAttribute Member member,Model model) {
//	//	this.userDetails = userDetails;
		System.out.println(memeberRepository);
		Member inserted_user= memeberRepository.save(member);
		System.out.println(inserted_user);
		model.addAttribute("Inserted"+inserted_user.getName());
		return "memberInfo";
	}
}
