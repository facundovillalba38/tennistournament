package com.tournament.geopagos.service;

import com.tournament.geopagos.entity.FemalePlayer;
import com.tournament.geopagos.entity.MalePlayer;
import com.tournament.geopagos.entity.Player;
import com.tournament.geopagos.exception.ApiRequestException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

@Service
public class TournamentService {

    public String getMaleWinner(List<MalePlayer> players) {
        // cast de maleplayer list to player list to validate the size
        List<Player> playerList = (List<Player>)(List<?>) players;
        this.validateSize(playerList);
        for(MalePlayer mp : players){
            this.validateFields(mp);
        }

        return players.get(0).getName();
    }

    public FemalePlayer getFemaleWinner(List<FemalePlayer> players) {
        return null;
    }

    private Player winnerLogic(List<Player> players){
        return null;
    }

    private void validateSize(List<Player> players){
        if(players.size()%2!=0){
            throw new ApiRequestException("Players list has to be even");
        }
    }

    private void validateFields(Player mp){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Player>> violations = validator.validate(mp);
        for (ConstraintViolation<Player> violation : violations) {
            throw new ApiRequestException(mp.getName() + "'s "+ violation.getMessage());
        }
    }


}
