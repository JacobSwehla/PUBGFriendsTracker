package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Relationships {

  @JsonProperty("assets")
  Object assets;

  @JsonProperty("data")
  DataHolder data;

  @JsonProperty("matches")
  Matches matches;

}
