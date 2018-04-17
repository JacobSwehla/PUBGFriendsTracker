package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ws.rs.core.MediaType;
import java.util.List;

public class Player {

  @JsonProperty("type")
  String type;

  @JsonProperty("id")
  String playerID;

  @JsonProperty("attributes")
  PlayerAtributes attributes;

  @JsonProperty("relationships")
  Relationships relationships;

  @JsonProperty("matches")
  Matches matches;

  @JsonProperty("links")
  Links links;


}
