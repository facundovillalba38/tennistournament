package com.tournament.geopagos.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Getter
@Setter
public class MalePlayer extends Player{
    @JsonProperty
    @Max(value=100, message = "strength should not be greater than 100")
    private Integer strength;
    @JsonProperty
    @Max(value=100, message = "speed should not be greater than 100")
    private Integer speed;

    @Builder
    public MalePlayer(String name, Integer ability, Integer strength, Integer speed) {
        super(name, ability);
        this.strength = strength;
        this.speed = speed;
    }
}
