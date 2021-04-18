package com.mobiquity.atmlocator.components;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiquity.atmlocator.dto.AtmLocatorDTO;

/**
 * Component class for to load atm information from supplied URL
 * @author tbabu
 *
 */

@Component
public class ATMLocatorComponent {

	private RestTemplate restTemplate;

	@Autowired
	public ATMLocatorComponent(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Cacheable("atmlocator")
	public List<AtmLocatorDTO> loadATMFromURI() throws JsonMappingException, JsonProcessingException {
		String response = restTemplate.getForObject("https://www.ing.nl/api/locator/atms/", String.class);
		
		//FIX-ME,currently response coming incorrectly,due to that removing first 5 characters
		String modifiedResponseStr = response.substring(6, response.length());
		ObjectMapper objectMapper = new ObjectMapper();
		AtmLocatorDTO[] atmDto = objectMapper.readValue(modifiedResponseStr, AtmLocatorDTO[].class);
		return Arrays.asList(atmDto);
	}

}
