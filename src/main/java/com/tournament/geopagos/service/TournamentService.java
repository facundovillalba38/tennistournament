package com.tournament.geopagos.service;

import com.tournament.geopagos.entity.FemalePlayer;
import com.tournament.geopagos.entity.MalePlayer;
import com.tournament.geopagos.entity.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {

    public Player getMaleWinner(List<MalePlayer> players) {
        return null;
    }

    public Player getFemaleWinner(List<FemalePlayer> players) {
        return null;
    }

    private Boolean checkGender(List<Player> players){
        return true;
    }
}
