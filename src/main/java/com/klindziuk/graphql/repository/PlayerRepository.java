/*
 * Copyright (c) 2021. Dandelion tutorials
 */

package com.klindziuk.graphql.repository;

import com.klindziuk.graphql.model.Player;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

public interface PlayerRepository extends ReactiveCrudRepository<Player, Integer> {

  Mono<Player> findByName(String name);
  Mono<Player> deleteByName(String name);
  Flux<Player> findByClub(String club);
  Flux<Player> findByNationality(String nationality);

}