package org.example.bankapisenai;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculadoraTests {
    private Calculadora calculadora = new Calculadora();


    @Test void deveSomarDoisNumeroCorretamente() {
        //Arrange
        int expect = 30;
        
        //Act - Execução do teste
        int result = calculadora.somar(10, 20);

        //Assert - Verificação do teste
        assertEquals(expect, result);
    }

    @Test void deveMultiplicarDoisNumerosCorretamente() {
        //Arrange
        int expect = 50;

        //Act - Execução
        int result = calculadora.multiplicar(10, 5);

        //Assert - Verificação do teste
        assertEquals(expect, result);
    }

    @Test void deveDividirDoisNumerosCorretamente() throws Exception {
        //Arrange
        int expect = 2;

        //Act - Execução
        int result = calculadora.divisao(10, 5);

        //Assert - Verificação do teste
        assertEquals(expect, result);
    }

    @Test void naoDeveDividirPorZero() {
        int expect = 0;

        assertThrows(Exception.class, () -> calculadora.divisao(10, 0));
    }

}
