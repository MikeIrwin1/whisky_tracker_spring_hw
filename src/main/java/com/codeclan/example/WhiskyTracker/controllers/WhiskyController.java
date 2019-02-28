package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/year/{year}")
    public List<Whisky> getAllWhiskiesByYear(@PathVariable int year){
        return whiskyRepository.getAllWhiskiesByYear(year);
    }

    @GetMapping(value = "distilleries/{distillery_id}/{age}")
    public List<Whisky> getAllWhiskiesFromDistilleryByAge(@PathVariable Long distillery_id, @PathVariable int age){
        return whiskyRepository.getAllWhiskiesFromGivenDistilleryOfGivenAge(distillery_id, age);
    }


    @GetMapping(value = "/regions/{region}")
    public List<Whisky> getAllWhiskiesByRegion(@PathVariable String region){
        return whiskyRepository.getAllWhiskiesbyRegion(region);
    }
}
