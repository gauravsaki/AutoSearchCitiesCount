package com.hsbc.msservice.autosearch.service

import org.springframework.stereotype.Service


interface AutoSearchService {
    fun getSuggestion(text : String): MutableList<String>?;
}