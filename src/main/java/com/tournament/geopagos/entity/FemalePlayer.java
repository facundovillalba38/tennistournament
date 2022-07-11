package com.tournament.geopagos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class FemalePlayer extends Player{
    private Integer reaction;

    public FemalePlayer(String name, Integer hability, Integer reaction) {
        super(name, hability);
        this.reaction = reaction;
    }
}
