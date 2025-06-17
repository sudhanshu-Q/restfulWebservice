package com.rest.webservice.restful_Webservices.enquiry;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Enquiry_Details")
public class EnquiryUs {
	
	
	@Id
	@GeneratedValue
	@Column(name="sn_no")
	private int serialNo;
	private String name;
	private String email;
	private String message;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "EnquiryUs [name=" + name + ", email=" + email + ", message=" + message + "]";
	}
	
	


}