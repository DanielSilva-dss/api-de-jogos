package com.jogocatalogo.jogo_api.service;

import com.jogocatalogo.jogo_api.entity.Cliente;
import com.jogocatalogo.jogo_api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Metodo para criar/salvar um cliente (gera o ID aqui)
    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Busca todos os clientes
    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    // Busca um cliente por ID
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(Long.valueOf(String.valueOf(id)));
        return cliente.orElse(null);
    }

    // Atualiza um cliente existente
    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        Cliente clienteExistente = buscarPorId(id);
        if (clienteExistente == null) return null;

        // Aqui vem a lógica de atualização seletiva
        if (clienteAtualizado.getNome() != null) {
            clienteExistente.setNome(clienteAtualizado.getNome());
        }
        if (clienteAtualizado.getEmail() != null) {
            clienteExistente.setEmail(clienteAtualizado.getEmail());
        }
        if (clienteAtualizado.getCpf() != null) {
            clienteExistente.setCpf(clienteAtualizado.getCpf());
        }
        if (clienteAtualizado.getTelefone() != null) {
            clienteExistente.setTelefone(clienteAtualizado.getTelefone());
        }

        return clienteRepository.save(clienteExistente);
    }

    // Deleta um cliente
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(Long.valueOf(String.valueOf(id)));
    }

    // Busca por nome
    public List<Cliente> buscarPorNome(String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }
}