package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Match {

  @JsonProperty("id")
  String id;

  @JsonProperty("type")
  String type;

}
