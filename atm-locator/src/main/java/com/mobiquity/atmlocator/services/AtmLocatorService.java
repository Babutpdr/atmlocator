package com.mobiquity.atmlocator.services;

import java.util.List;

import com.mobiquity.atmlocator.dto.AtmLocatorDTO;

public interface AtmLocatorService {
	
	/**
	 * Return list of all atms
	 * @return list of atms
	 */
	public List<AtmLocatorDTO> getAllAtms();

	/**
	 * Returns list of items based on city name
	 * @param city name of the city
	 * @return list of atms
	 */
	public List<AtmLocatorDTO> getAtmsByLocationName(String city);
}
