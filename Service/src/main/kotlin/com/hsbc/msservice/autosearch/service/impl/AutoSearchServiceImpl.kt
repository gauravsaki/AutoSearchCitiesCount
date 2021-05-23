package com.hsbc.msservice.autosearch.service.impl

import com.hsbc.msservice.autosearch.repository.AutoSearchRepo
import com.hsbc.msservice.autosearch.repository.AutoSearchRepoImpl
import com.hsbc.msservice.autosearch.service.AutoSearchService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.function.Predicate
import java.util.stream.Collectors
@Service("AutoSearchService")
class AutoSearchServiceImpl(
  @Autowired private val autoSearchRepoImpl: AutoSearchRepoImpl
) : AutoSearchService {

    override fun getSuggestion(text: String): MutableList<String> ? {
       return autoSearchRepoImpl.getAllCityName()?.stream()?.filter { isStartWith(text,it) }?.map{ it }?.collect(Collectors.toList());
    }


    fun isStartWith( str1: String, str2: String):Boolean{
       return str2.startsWith(str1,true)
    }
}