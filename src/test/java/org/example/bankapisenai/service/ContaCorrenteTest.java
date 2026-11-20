package org.example.bankapisenai.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.example.bankapisenai.model.ContaCorrente;
import org.junit.jupiter.api.Test;

public class ContaCorrenteTest {

    @Test public void deveSacarContaCorrenteCorretamente() {
        ContaCorrente cc = new ContaCorrente();
        cc.setSaldo(new BigDecimal(1500));

        var service = new ContaCorrenteService();

        var result = service.realizarSaque(new BigDecimal(500), cc);

        assertTrue(result.getSaldo().equals(new  BigDecimal(1000)));
    }
    
}
