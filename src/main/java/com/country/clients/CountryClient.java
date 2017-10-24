
package com.country.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.country.wsdl.GetCountryByCountryCode;
import com.country.wsdl.GetCountryByCountryCodeResponse;

public class CountryClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

	public GetCountryByCountryCodeResponse getQuote(String code) {

		GetCountryByCountryCode request = new GetCountryByCountryCode();
		
		request.setCountryCode(code);

		log.info("Requesting country for " + code);

		GetCountryByCountryCodeResponse response = (GetCountryByCountryCodeResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://www.webservicex.com/country.asmx",
						request,
						new SoapActionCallback("http://www.webserviceX.NET/GetCountryByCountryCode"));

		return response;
	}

}
