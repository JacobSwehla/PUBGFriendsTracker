package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Links {

  @JsonProperty("schema")
  String schema;

  @JsonProperty("self")
  String self;

}
