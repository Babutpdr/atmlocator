package com.mobiquity.atmlocator.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mobiquity.atmlocator.components.ATMLocatorComponent;
import com.mobiquity.atmlocator.dto.AtmLocatorDTO;
import com.mobiquity.atmlocator.services.AtmLocatorService;

/**
 * Implementation class for service methods of atm locator
 * @author tbabu
 *
 */

@Service
public class AtmLocatorServiceImpl implements AtmLocatorService {

	private Logger log = LoggerFactory.getLogger(AtmLocatorServiceImpl.class);

	@Autowired
	private ATMLocatorComponent atmLocationComponent;

	@Override
	public List<AtmLocatorDTO> getAllAtms() {
		log.info("AtmLocatorServiceImpl-> getAllAtms() Start");
		List<AtmLocatorDTO> atms = new ArrayList<>();
		try {
			atms = atmLocationComponent.loadATMFromURI();
		} catch (JsonProcessingException e) {
			log.info("Error while getting atm information from the http url "+e.getMessage());
		}
		log.info("AtmLocatorServiceImpl-> getAllAtms() End");
		return atms;
	}

	@Override
	public List<AtmLocatorDTO> getAtmsByLocationName(String cityName) {
		return getAllAtms().stream().filter(a -> a.getAddress().getCity().equalsIgnoreCase(cityName))
				.collect(Collectors.toList());
	}

}
