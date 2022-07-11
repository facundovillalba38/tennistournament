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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TournamentService {

    public String getMaleWinner(List<MalePlayer> players) {
        // cast de maleplayer list to player list to validate the size
        List<Player> playerList = (List<Player>)(List<?>) players;
        this.validateSize(playerList);
        for(MalePlayer mp : players){
            this.validateFields(mp);
        }

        return this.winnerMaleLogic(players).getName();
    }



    // Recursive method
    private MalePlayer winnerMaleLogic(List<MalePlayer> players){
        List<MalePlayer> winners = new ArrayList<>();
        List<MalePlayer> loosers = new ArrayList<>();
        while(!players.isEmpty()){
            MalePlayer p1 = players.get(0);
            MalePlayer p2 = players.get(players.size()-1);
            System.out.println("\n\n"+p1.getName()+" vs "+p2.getName());
            if(skillsMale(p1, p2)){
                winners.add(p1);
                System.out.println("Winner: "+p1.getName());
                loosers.add(p2);
            }else{
                winners.add(p2);
                System.out.println("Winner: "+p2.getName());
                loosers.add(p1);
            }
            players.remove(p1);
            players.remove(p2);
        }
        if(winners.size()%2==0){
            players = winners.stream().collect(Collectors.toList());
            return winnerMaleLogic(players);
        }else{
            return winners.get(0);
        }
    }

    private Boolean skillsMale(MalePlayer p1, MalePlayer p2){
        // with this function the ability could randomly decrease or increase by 20.
        p1.setAbility(p1.getAbility()+(int)(Math.random()*(20-(-20))+(-20)));
        p2.setAbility(p2.getAbility()+(int)(Math.random()*(20-(-20))+(-20)));
        // if you have better ability (including the random modification) AND one of the other skills (speed or strength) you win.
        if(p1.getAbility() >= p2.getAbility() && (p1.getSpeed()>= p2.getSpeed() || p1.getStrength() >= p2.getStrength())){
            return true;
        }else{
            return false;
        }
    }

    public String getFemaleWinner(List<FemalePlayer> players) {
        // cast de maleplayer list to player list to validate the size
        List<Player> playerList = (List<Player>)(List<?>) players;
        this.validateSize(playerList);
        for(FemalePlayer mp : players){
            this.validateFields(mp);
        }

        return this.winnerFemaleLogic(players).getName();
    }

    private FemalePlayer winnerFemaleLogic(List<FemalePlayer> players){
        List<FemalePlayer> winners = new ArrayList<>();
        List<FemalePlayer> loosers = new ArrayList<>();
        while(!players.isEmpty()){
            FemalePlayer p1 = players.get(0);
            FemalePlayer p2 = players.get(players.size()-1);
            System.out.println("\n\n"+p1.getName()+" vs "+p2.getName());
            if(skillsFemale(p1, p2)){
                winners.add(p1);
                System.out.println("Winner: "+p1.getName());
                loosers.add(p2);
            }else{
                winners.add(p2);
                System.out.println("Winner: "+p2.getName());
                loosers.add(p1);
            }
            players.remove(p1);
            players.remove(p2);
        }
        if(winners.size()%2==0){
            players = winners.stream().collect(Collectors.toList());
            return winnerFemaleLogic(players);
        }else{
            return winners.get(0);
        }
    }

    private boolean skillsFemale(FemalePlayer p1, FemalePlayer p2) {
        // with this function the ability could randomly decrease or increase by 20.
        p1.setAbility(p1.getAbility()+(int)(Math.random()*(20-(-20))+(-20)));
        p2.setAbility(p2.getAbility()+(int)(Math.random()*(20-(-20))+(-20)));
        // if ability (modified by lucky/random) plus reaction of a player is higher than the other player, you win
        if(p1.getAbility() + p1.getReaction() >= p2.getAbility() + p2.getReaction()){
            return true;
        }else{
            return false;
        }

    }

    private void validateSize(List<Player> players){
        if(players.size()%4!=0){
            throw new ApiRequestException("Players list size has to be multiple of 4.");
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
