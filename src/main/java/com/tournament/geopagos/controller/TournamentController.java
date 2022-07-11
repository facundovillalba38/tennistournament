package com.tournament.geopagos.controller;

import com.tournament.geopagos.entity.FemalePlayer;
import com.tournament.geopagos.entity.MalePlayer;
import com.tournament.geopagos.entity.Player;
import com.tournament.geopagos.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tournament")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GetMapping("/male")
    private Player maleTournament(@RequestBody List<MalePlayer> players){
        return tournamentService.getMaleWinner(players);
    }

    @GetMapping("/female")
    private Player femaleTournament(@RequestBody List<FemalePlayer> players){
        return tournamentService.getFemaleWinner(players);
    }

}
