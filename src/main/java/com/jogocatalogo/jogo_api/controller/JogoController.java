package com.jogocatalogo.jogo_api.controller;

import com.jogocatalogo.jogo_api.entity.Jogo;
import com.jogocatalogo.jogo_api.service.JogoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/jogo")
public class JogoController {

    private final JogoService jogoService;

    @Autowired
    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @PostMapping
    public ResponseEntity<Jogo> salvar(@Valid @RequestBody Jogo jogo) {
        Jogo jogoSalvo = jogoService.criarJogo(jogo);
        return ResponseEntity.status(HttpStatus.CREATED).body(jogoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Jogo>> buscarTodos() {
        List<Jogo> jogos = jogoService.buscarTodos();
        return ResponseEntity.ok(jogos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> buscarPorId(@PathVariable Long id) {
        Jogo jogo = jogoService.buscarPorId(id);
        if (jogo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(jogo);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Jogo> atualizar(@PathVariable Long id, @Valid @RequestBody Jogo jogoAtualizado) {
        Jogo jogo = jogoService.atualizarJogo(id, jogoAtualizado);
        if (jogo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(jogo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Jogo jogo = jogoService.buscarPorId(id);
        if (jogo == null) {
            return ResponseEntity.notFound().build();
        }
        jogoService.deletarJogo(id);
        return ResponseEntity.noContent().build();
    }

}