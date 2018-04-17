package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Matches {

  @JsonProperty("data")
  List<Match> data;

}
