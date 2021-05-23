package com.hsbc.msservice.autosearch.repository

import org.springframework.stereotype.Component

interface AutoSearchRepo {
    fun getAllCityName():MutableList<String>?;
    fun loadAllCitiNames();
}