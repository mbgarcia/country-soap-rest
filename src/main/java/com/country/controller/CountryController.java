package com.country.controller;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.country.clients.CountryClient;
import com.country.wsdl.GetCountryByCountryCodeResponse;

@RestController
public class CountryController {
		
	@Autowired
	CountryClient countryClient;

	@RequestMapping(value="/code", produces="application/xml")
	public String getByCode(@RequestParam(name="code", defaultValue="BR") String code) throws IOException, JAXBException{
		GetCountryByCountryCodeResponse response = countryClient.getQuote(code);
		
		System.out.println(response.getGetCountryByCountryCodeResult());
		
		String xml = response.getGetCountryByCountryCodeResult();
				
		System.out.println("Done");
		
		System.out.println(xml);
		
		return xml;
	}
}
