package com.jogocatalogo.jogo_api.service;

import com.jogocatalogo.jogo_api.entity.Jogo;
import com.jogocatalogo.jogo_api.repository.JogoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    private final JogoRepository jogoRepository;

    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    // Metodo para criar/salvar um jogo (gera o ID aqui)
    public Jogo criarJogo(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    // Busca todos os jogos
    public List<Jogo> buscarTodos() {
        return jogoRepository.findAll();
    }

    // Busca um jogo por ID
    public Jogo buscarPorId(Long id) {
        Optional<Jogo> jogo = jogoRepository.findById(id);
        return jogo.orElse(null);
    }

    // Atualiza um jogo existente
    public Jogo atualizarJogo(Long id, Jogo jogoAtualizado) {
        Jogo jogoExistente = buscarPorId(id);
        if (jogoExistente == null) return null;

        // Aqui vem a lógica de atualização seletiva
        if (jogoAtualizado.getTitulo() != null) {
            jogoExistente.setTitulo(jogoAtualizado.getTitulo());
        }
        if (jogoAtualizado.getGenero() != null) {
            jogoExistente.setGenero(jogoAtualizado.getGenero());
        }
        if (jogoAtualizado.getPlataforma() != null) {
            jogoExistente.setPlataforma(jogoAtualizado.getPlataforma());
        }
        if (jogoAtualizado.getAnoLancamento() != null) {
            jogoExistente.setAnoLancamento(jogoAtualizado.getAnoLancamento());
        }
        if (jogoAtualizado.getDescricao() != null) {
            jogoExistente.setDescricao(jogoAtualizado.getDescricao());
        }
        if (jogoAtualizado.getPreco() != null) {
            jogoExistente.setPreco(jogoAtualizado.getPreco());
        }

        return jogoRepository.save(jogoExistente);
    }

    // Deleta um jogo
    public void deletarJogo(Long id) {
        jogoRepository.deleteById(id);
    }

    // Busca por nome
    public List<Jogo> buscarPorTitulo(String titulo) {
        return jogoRepository.findByTituloContainingIgnoreCase(titulo);
    }

}
