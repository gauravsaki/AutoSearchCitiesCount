package com.hsbc.msservice.autosearch.repository

import com.hsbc.msservice.autosearch.model.CityDetail
import lombok.Data
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.util.Collections.emptyList
import java.util.stream.Collector
import java.util.stream.Collectors
import javax.annotation.PostConstruct


@Component
class AutoSearchRepoImpl( @Autowired private val restTemplate :RestTemplate) : AutoSearchRepo {
    private  var cityNameList : MutableList<String>? = null;
   ;
    override fun getAllCityName(): MutableList<String>? {
        return cityNameList;

    }

    @PostConstruct
    override fun loadAllCitiNames() {
        val response = restTemplate.getForEntity(
            "https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=b6907d289e10d714a6e88b30761fae22",
            CityDetail::class.java
        );
        cityNameList = if(response.hasBody()) {
            response.body?.list?.stream()?.map { l->l.name }?.collect(Collectors.toList());
        }else{
            null;
        }
    }

}