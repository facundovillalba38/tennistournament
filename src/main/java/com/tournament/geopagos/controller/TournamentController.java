package com.tournament.geopagos.controller;

import com.tournament.geopagos.entity.FemalePlayer;
import com.tournament.geopagos.entity.MalePlayer;
import com.tournament.geopagos.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/api/tournament")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @PostMapping("/male")
    private String maleTournamentWinner(
            @RequestBody
            @NotEmpty(message = "Input players list cannot be empty.")
            List<MalePlayer> players){
        return tournamentService.getMaleWinner(players);
    }

    @PostMapping("/female")
    private FemalePlayer femaleTournamentWinner(@RequestBody List<FemalePlayer> players){
        return tournamentService.getFemaleWinner(players);
    }

}
