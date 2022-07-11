package com.tournament.geopagos.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Player {
    @JsonProperty
    @NotNull(message = "Name cannot be null")
    protected String name;
    @JsonProperty
    @Max(value=100, message = "ability should not be greater than 100")
    protected int ability;
}
