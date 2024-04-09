package br.com.game.rpg.service;

import br.com.game.rpg.dto.PlayerDto;
import br.com.game.rpg.model.Player;
import br.com.game.rpg.repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository repository;

    @Autowired
    ModelMapper modelMapper;

    public Page<PlayerDto> obterTodos(Pageable paginacao) {
        return repository.findAll(paginacao).map(p -> modelMapper.map(p, PlayerDto.class));
    }

    public PlayerDto obterporId(Long id) {
        Player player = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(player, PlayerDto.class);
    }

    public PlayerDto criarPlayer(PlayerDto dto) {
        Player player = modelMapper.map(dto, Player.class);
        repository.save(player);

        return modelMapper.map(player, PlayerDto.class);
    }

    public PlayerDto atualizarPlayer(Long id, PlayerDto dto) {
        Player player = modelMapper.map(dto, Player.class);
        player.setId(id);
        player = repository.save(player);
        return modelMapper.map(player, PlayerDto.class);
    }

    public void excluirPlayer(Long id) {
        repository.deleteById(id);
    }
}
