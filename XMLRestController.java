package com.javasampleapproach.xmlrestservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javasampleapproach.xmlrestservice.model.AimTransactionResponse;
import com.javasampleapproach.xmlrestservice.model.Customer;
import com.javasampleapproach.xmlrestservice.model.ReplyTransaction;

@RestController
public class XMLRestController {
	
	 @RequestMapping(value = "/customer", method = RequestMethod.GET)
	 public Customer getCustomer(){
		 return new Customer("Peter", "Smith", 30);
	 }
	 
	 @RequestMapping(value = "/customer", method = RequestMethod.POST, produces="application/xml", consumes="application/xml")
	 public AimTransactionResponse postCustomer(@RequestBody ReplyTransaction customer){
		 System.out.println(customer);
		 AimTransactionResponse as = new AimTransactionResponse();
		 as.setAcknowledgement("success");
		 return as;
	 }
	 
	 
	 @RequestMapping(value = "/create", method = RequestMethod.GET, produces="application/xml")
	 public AimTransactionResponse create(){
		 final String uri = "http://localhost:8080/customer";
		 ReplyTransaction request = new ReplyTransaction();
		 request.setMmsName("TestMms");
		 request.setMmsRefId("123");
		 request.setPrecertId("1234");
		 request.setReturnCode("123");
		 request.setTransactionId("1234");
		 
		 
		 RestTemplate restTemplate = new RestTemplate();
		 List<HttpMessageConverter<?>> lst = new ArrayList<>();
		 lst.add(new Jaxb2RootElementHttpMessageConverter());
	
		 restTemplate.setMessageConverters(lst);
		 AimTransactionResponse result = restTemplate.postForObject( uri, request, AimTransactionResponse.class);
		 
		 return result;
	 }
}