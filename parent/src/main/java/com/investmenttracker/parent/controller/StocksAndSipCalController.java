package com.investmenttracker.parent.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.investmenttracker.parent.entity.SIPDetails;
import com.investmenttracker.parent.entity.Stocks;
import com.investmenttracker.parent.service.impl.StocksAndSipCalServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@EnableCircuitBreaker
@RestController
public class StocksAndSipCalController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StocksAndSipCalServiceImpl service;
	
	@GetMapping("/getStocks")
	public List<Stocks> getStockDetails() {

		LOGGER.info("Controller");
		return service.getStockDetails();
	
	}
	
	@PostMapping("/addStocktoUser")
	public String addStocktoUser(@RequestBody Stocks data) {

		LOGGER.info("Controller");
		return service.addStocktoUser(data);
	}
	
	@PostMapping("/calculateSIP")
	public double calculateSIP(@RequestBody SIPDetails data) {

		LOGGER.info("Controller");
		return service.calculateSIP(data);
	}
	
	@GetMapping("/getStockDetails/{name}")
    public String getStockDetails(@PathVariable String name) {

        LOGGER.info("Controller");
        return service.getStockDetails(name);
    
    }

}
