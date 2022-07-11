package com.tournament.geopagos.entity;

import lombok.*;

@Getter
@Setter
public class MalePlayer extends Player{
    private Integer strenght;
    private Integer speed;

    @Builder
    public MalePlayer(String name, Integer hability, Integer strenght, Integer speed) {
        super(name, hability);
        this.strenght = strenght;
        this.speed = speed;
    }
}
