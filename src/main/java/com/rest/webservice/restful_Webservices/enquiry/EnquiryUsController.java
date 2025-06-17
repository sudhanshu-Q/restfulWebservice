package com.rest.webservice.restful_Webservices.enquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EnquiryUsController {

	@Autowired
	private EnquiryUsRepository enquiryUsRepository;

	
	@GetMapping("/newEnquiry")
	public String showEnqForm(Model model) {
		EnquiryUs enquiryUs=new EnquiryUs();
		model.addAttribute("user", enquiryUs);
		return "enquiryPage";
	}

	
	@PostMapping("/newEnquiry")
	public String enquiryForm(@ModelAttribute("user") EnquiryUs member,Model model) {
		System.out.println(enquiryUsRepository);
		EnquiryUs inserted_user= enquiryUsRepository.save(member);
		System.out.println(inserted_user);
		model.addAttribute("Inserted"+inserted_user.getName());
		return "enquirySubmit";
	}
}
