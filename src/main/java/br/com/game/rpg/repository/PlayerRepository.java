package br.com.game.rpg.repository;

import br.com.game.rpg.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
