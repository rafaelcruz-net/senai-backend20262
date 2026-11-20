package org.example.bankapisenai.controllers;

import java.util.List;

import org.example.bankapisenai.model.Cliente;
import org.example.bankapisenai.repository.ClienteRepository;
import org.example.bankapisenai.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping 
    public List<Cliente> getAll() {
        return this.service.buscarTodos();
    }

    @GetMapping("/{id}") 
    public ResponseEntity<Cliente> getById(@PathVariable Integer id) {
        var cliente = this.service.buscarPorId(id);

        if (cliente.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(cliente.get());
    }

    @PostMapping 
    public ResponseEntity<Cliente> save(@RequestBody Cliente request) throws Exception {
        this.service.cadastrar(request);
        return ResponseEntity.ok(request);
    }
    
}
