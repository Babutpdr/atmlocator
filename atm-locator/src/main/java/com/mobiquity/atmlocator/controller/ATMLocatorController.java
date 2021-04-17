package com.mobiquity.atmlocator.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobiquity.atmlocator.dto.AtmLocatorDTO;
import com.mobiquity.atmlocator.dto.AtmResponseWarraper;
import com.mobiquity.atmlocator.services.AtmLocatorService;


@RestController
@RequestMapping("api/v1/atmlocator")
public class ATMLocatorController {

	@Autowired
	private AtmLocatorService atmLocatorService;

	@GetMapping(value="/atms")
	public AtmResponseWarraper getATMs(@RequestParam(value = "city", required = false) String city) {
		AtmResponseWarraper atmResponseWarraper = new AtmResponseWarraper(); 
		if (StringUtils.isNotEmpty(city)) {
			atmResponseWarraper.setAtmDTOs(atmLocatorService.getAtmsByLocationName(city));
			return atmResponseWarraper;
		}
		atmResponseWarraper.setAtmDTOs(atmLocatorService.getAllAtms());
		return atmResponseWarraper;
	}

}
