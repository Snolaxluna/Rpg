package br.com.game.rpg.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class PlayerDto {
    private Long id;
    private String nome;
    private int dado;

    public void mudarDado() {
        Random random = new Random();
        int num = random.nextInt(20 + 1);
        setDado(num);
    }
}
