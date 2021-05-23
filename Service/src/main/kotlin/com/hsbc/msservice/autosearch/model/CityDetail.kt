package com.hsbc.msservice.autosearch.model

import com.fasterxml.jackson.annotation.JsonProperty


data class CityDetail (

   @JsonProperty("list")
   var list : Collection<com.hsbc.msservice.autosearch.model.List>

) {

}