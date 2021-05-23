package com.hsbc.msservice.autosearch.model

import com.fasterxml.jackson.annotation.JsonProperty

data class List (
   @JsonProperty("name")
   var name : String

)