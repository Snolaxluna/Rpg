package br.com.game.rpg.controller;

import br.com.game.rpg.dto.PlayerDto;
import br.com.game.rpg.service.PlayerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @GetMapping
    public Page<PlayerDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return service.obterTodos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDto> detalhar(@PathVariable @NotNull Long id){
        PlayerDto dto = service.obterPorId(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PlayerDto> cadastrar(@RequestBody @Valid PlayerDto dto,
                                               UriComponentsBuilder uriBuilder){
        PlayerDto playerDto = service.criarPlayer(dto);
        URI endereco = uriBuilder.path("/players/{id}").buildAndExpand(playerDto.id()).toUri();

        return ResponseEntity.created(endereco).body(playerDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDto> atualizar(@PathVariable @NotNull Long id,
                                               @RequestBody @Valid PlayerDto dto){
        PlayerDto atualizado = service.atualizarPlayer(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PlayerDto> remover(@PathVariable @NotNull Long id){
        service.excluirPlayer(id);
        return ResponseEntity.noContent().build();
    }
}
