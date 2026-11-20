package org.example.bankapisenai.controllers;

import java.util.List;

import org.example.bankapisenai.model.Cliente;
import org.example.bankapisenai.model.ContaCorrente;
import org.example.bankapisenai.repository.ClienteRepository;
import org.example.bankapisenai.repository.ContaCorrenteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api/contas")
public class ContaCorrenteController {

    private final ContaCorrenteRepository repository;
    private final ClienteRepository clienteRepository;

    public ContaCorrenteController(ContaCorrenteRepository repository, ClienteRepository clienteRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping 
    public List<ContaCorrente> getAll() {
        return this.repository.findAll();
    }

    @GetMapping("{id}") 
    public ResponseEntity<ContaCorrente> getById(@PathVariable Integer id) {
        var conta = this.repository.findById(id);

        if (conta.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(conta.get());
    }

    @PostMapping("{idCliente}") 
    public ResponseEntity<ContaCorrente> save(@PathVariable Integer idCliente, @RequestBody ContaCorrente request) {
        
        var cliente = this.clienteRepository.findById(idCliente);

        if (cliente.isEmpty())
            return ResponseEntity.notFound().build();

        request.setCliente(cliente.get());
        
        this.repository.save(request);
        return ResponseEntity.ok(request);
    }
    
}
