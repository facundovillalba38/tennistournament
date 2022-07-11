package com.tournament.geopagos.controller;

import com.tournament.geopagos.entity.Player;
import com.tournament.geopagos.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tournament")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GetMapping
    private Player getWinner(List<Player> players){
        return tournamentService.getWinner(players);
    }

}
