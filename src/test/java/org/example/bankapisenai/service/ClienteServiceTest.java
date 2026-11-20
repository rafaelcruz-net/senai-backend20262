package org.example.bankapisenai.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.example.bankapisenai.model.Cliente;
import org.example.bankapisenai.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {
    @Mock 
    private ClienteRepository repository;

    @InjectMocks
    private ClienteService service;

    @Test void deveBuscarClientePorIdCorretamente() {
        //Arrange
        Cliente cliente = new Cliente();
        cliente.setId(1); 
        cliente.setNome("Maria");
        cliente.setEmail("maria@gmail.com");
        when(repository.findById(1)).thenReturn(Optional.of(cliente));

        //Act - Execução
        var result = service.buscarPorId(1);

        //Asserts
        assertEquals("Maria", result.get().getNome());
        assertEquals("maria@gmail.com", result.get().getEmail());

    }

    @Test void deveCadastrarClienteCorretamente() throws Exception {
        //Arrange
        Cliente cliente = new Cliente();
        cliente.setId(1); 
        cliente.setNome("Maria");
        cliente.setEmail("maria@gmail.com");

        when(service.cadastrar(cliente)).thenReturn(cliente);

        //Act - Execução
        var result = service.cadastrar(cliente);

        assertEquals(cliente.getId(), result.getId());
        assertEquals(cliente.getNome(), result.getNome());
        assertEquals(cliente.getEmail(), result.getEmail());

    }

    @Test void naoDeveCadastrarClienteQuandoNomeVazioOuNulo() throws Exception {
        //Arrange
        Cliente cliente = new Cliente();
        cliente.setId(1); 
        cliente.setNome(null);

        //Act - Assert
        assertThrows(Exception.class, () -> service.cadastrar(cliente));

        //Verificar, nenhuma chamada de cadastro para o banco
        verify(repository, never()).save(any());
    }

    
}
