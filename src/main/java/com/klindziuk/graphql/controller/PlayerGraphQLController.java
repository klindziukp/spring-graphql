/*
 * Copyright (c) 2021. Dandelion tutorials
 */

package com.klindziuk.graphql.controller;

import com.klindziuk.graphql.model.Player;
import com.klindziuk.graphql.model.PlayerInput;
import com.klindziuk.graphql.service.PlayerService;
import java.util.logging.Level;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

@Slf4j
@Controller
public class PlayerGraphQLController {

  private final PlayerService playerService;

  @Autowired
  public PlayerGraphQLController(PlayerService playerService) {
    this.playerService = playerService;
  }

  @QueryMapping("getAllPlayers")
  Flux<Player> getAllPlayers() {
    log.info("Get all players using 'getAllPlayers' query");
    return processWithLog(this.playerService.getAllPlayers());
  }

  @QueryMapping("getPlayerById")
  Mono<Player> getPlayerById(@Argument Integer id) {
    log.info("Get player by id using 'getPlayerById' query");
    return processWithLog(this.playerService.getPlayerById(id));
  }

  @QueryMapping("getPlayerByName")
  Mono<Player> getPlayerByName(@Argument String name) {
    log.info("Get player by name using 'getPlayerByName' query");
    return processWithLog(this.playerService.getPlayerByName(name));
  }

  @QueryMapping("getPlayersByClub")
  Flux<Player> getPlayersByClub(@Argument String club) {
    log.info("Get players by club using 'getPlayersByClub' query");
    return processWithLog(this.playerService.getPlayersByClub(club));
  }

  @QueryMapping("getPlayersByNationality")
  Flux<Player> getPlayersByNationality(@Argument String nationality) {
    log.info("Get players by nationality using 'getPlayersByNationality' query");
    return processWithLog(this.playerService.getPlayersByNationality(nationality));
  }

  @MutationMapping("addPlayer")
  Mono<Player> addPlayer(@Argument PlayerInput playerInput) {
    log.info("Add player using 'addPlayer' mutation");
    return processWithLog(this.playerService.addPlayer(playerInput));
  }

  @MutationMapping("updatePlayer")
  Mono<Player> updatePlayer(@Argument Integer id, @Argument PlayerInput playerInput) {
    log.info("Updating player using 'updatePlayer' mutation");
    return processWithLog(this.playerService.updatePlayer(id, playerInput));
  }

  @MutationMapping("deletePlayerById")
  Mono<Player> deletePlayerById(@Argument Integer id) {
    log.info("Delete player using 'deletePlayerById' mutation");
    return processWithLog(this.playerService.deletePlayerById(id));
  }

  @MutationMapping("deletePlayerByName")
  Mono<Player> deletePlayerById(@Argument String name) {
    log.info("Delete player using 'deletePlayerByName' mutation");
    return processWithLog(this.playerService.deletePlayerByName(name));
  }

  private <T> Mono<T> processWithLog(Mono<T> monoToLog) {
    return monoToLog
        .log("PlayerGraphQLController.", Level.INFO, SignalType.ON_NEXT, SignalType.ON_COMPLETE);
  }

  private <T> Flux<T> processWithLog(Flux<T> fluxToLog) {
    return fluxToLog
        .log("PlayerGraphQLController.", Level.INFO, SignalType.ON_NEXT, SignalType.ON_COMPLETE);
  }
}
