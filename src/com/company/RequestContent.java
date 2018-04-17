package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RequestContent {

  @JsonProperty("data")
  List data;

  @JsonProperty("links")
  Object links;

  @JsonProperty("meta")
  Object meta;


}
