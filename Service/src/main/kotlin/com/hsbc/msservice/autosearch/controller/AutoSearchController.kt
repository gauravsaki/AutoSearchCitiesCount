package com.hsbc.msservice.autosearch.controller

import com.hsbc.msservice.autosearch.dto.CityCount
import com.hsbc.msservice.autosearch.model.CityDetail
import com.hsbc.msservice.autosearch.service.AutoSearchService
import com.hsbc.msservice.autosearch.service.impl.AutoSearchServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class AutoSearchController() {
    @Autowired
    @Qualifier("AutoSearchService")
    lateinit var autoSearchService: AutoSearchService;

    @CrossOrigin
    @GetMapping("api/v1/getCountOfCities/{text}")
     fun  getSuggestion(@PathVariable text : String) : ResponseEntity<CityCount> {
         var count = autoSearchService.getSuggestion(text)?.size  ;
         var cityCount = CityCount();
        if (count != null) {
            cityCount.count = count
        }else {
            cityCount.count = 0;
        }
        return ResponseEntity<CityCount>(cityCount, HttpStatus.OK);
    }



}