package com.mobiquity.atmlocator.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiquity.atmlocator.AtmLocatorApplication;
import com.mobiquity.atmlocator.dto.AtmLocatorDTO;
import com.mobiquity.atmlocator.services.AtmLocatorService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AtmLocatorApplication.class)
public class AtmLocatorServiceImplTest {
	
	private String mockCorrectCity = "Maasbracht";

	@Autowired
	@InjectMocks
	private AtmLocatorService atmLocatorService;

	private File atmTestData;

	private List<AtmLocatorDTO> atms;

	@Test
	public void shouldGetAtmByCityName() {
		List<AtmLocatorDTO> result = atmLocatorService.getAtmsByLocationName(mockCorrectCity);
		assertEquals(result.size(), 2);
	}

	@Test
	public void shouldGetAtmByIncorrectCityName() {
		List<AtmLocatorDTO> result = atmLocatorService.getAtmsByLocationName("abcd");
		assertEquals(result.size(), 0);
	}

	@AfterEach
	public void cleanTestData() {
		if (atms != null && atms.size() != 0) {
			atms.clear();
		}
		if (atmTestData != null) {
			atmTestData = null;
		}
	}

}
