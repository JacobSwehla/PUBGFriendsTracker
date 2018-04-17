package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerAtributes {

  @JsonProperty("name")
  String name;

  @JsonProperty("shardId")
  String shardId;

  @JsonProperty("stats")
  Object stats;

  @JsonProperty("createdAt")
  String createdAt;

  @JsonProperty("patchVersion")
  String version;

  @JsonProperty("titleId")
  String titleId;

  @JsonProperty("updatedAt")
  String updatedAt;

}
