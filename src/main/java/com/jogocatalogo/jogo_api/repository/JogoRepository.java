package com.jogocatalogo.jogo_api.repository;

import com.jogocatalogo.jogo_api.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo, Long> {

    List<Jogo> findByTituloContainingIgnoreCase(String titulo);

}
