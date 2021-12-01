/*
 * Copyright (c) 2021. Dandelion tutorials
 */

package com.klindziuk.graphql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerInput {

  @JsonProperty("name")         private String name;
  @JsonProperty("age")          private Integer age;
  @JsonProperty("club")         private String club;
  @JsonProperty("nationality")  private String nationality;
}
