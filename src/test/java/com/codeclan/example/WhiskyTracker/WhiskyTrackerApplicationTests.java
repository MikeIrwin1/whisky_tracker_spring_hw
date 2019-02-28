package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetWhiskiesByYear(){
		List<Whisky> results = whiskyRepository.getAllWhiskiesByYear(2018);
	}

	@Test
	public void canGetDistilleriesByRegion(){
		List<Distillery> results = distilleryRepository.getDistilleriesByRegion("Highland");
	}

	@Test
	public void canGetWhiskiesFromDistilleryWithGivenAge(){
		List<Whisky> results = whiskyRepository.getAllWhiskiesFromGivenDistilleryOfGivenAge(1L, 15);
	}

	@Test
	public void canGetWhiskiesByRegion(){
		List<Whisky> results = whiskyRepository.getAllWhiskiesbyRegion("Highland");
	}

}
