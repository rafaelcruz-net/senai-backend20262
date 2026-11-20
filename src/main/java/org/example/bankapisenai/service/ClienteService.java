package org.example.bankapisenai.service;

import java.util.List;
import java.util.Optional;

import org.example.bankapisenai.model.Cliente;
import org.example.bankapisenai.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service 
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Optional<Cliente> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Cliente> buscarTodos() {
        return repository.findAll();
    }


    public Cliente cadastrar(Cliente novoCliente) throws Exception {
        if (novoCliente.getNome() == null || novoCliente.getNome().isBlank()) {
            throw new Exception("Nome é obrigatório");
        }

        return repository.save(novoCliente);
    }

    
}
