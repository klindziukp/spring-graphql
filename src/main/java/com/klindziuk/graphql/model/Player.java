/*
 * Copyright (c) 2021. Dandelion tutorials
 */

package com.klindziuk.graphql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Player {

  @Id
  @JsonProperty("id")           private Integer id;
  @JsonProperty("name")         private String name;
  @JsonProperty("age")          private Integer age;
  @JsonProperty("club")         private String club;
  @JsonProperty("nationality")  private String nationality;

  public Player(PlayerInput playerInput) {
    this.name = Objects.requireNonNull(playerInput.getName());
    this.age = Objects.requireNonNull(playerInput.getAge());
    this.club = Objects.requireNonNull(playerInput.getClub());
    this.nationality = Objects.requireNonNull(playerInput.getNationality());
  }
}
