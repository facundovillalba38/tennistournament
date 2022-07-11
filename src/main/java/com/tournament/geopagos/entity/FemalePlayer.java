package com.tournament.geopagos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Getter
@Setter
public class FemalePlayer extends Player{
    @Max(value=100, message = "reaction should not be greater than 100")
    private Integer reaction;

    public FemalePlayer(String name, Integer ability, Integer reaction) {
        super(name, ability);
        this.reaction = reaction;
    }
}
