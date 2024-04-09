package br.com.game.rpg.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerDto {
    private Long id;
    private String nome;
    private int dado;
}
