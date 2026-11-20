package org.example.bankapisenai.service;

import java.math.BigDecimal;

import org.example.bankapisenai.model.ContaCorrente;
import org.springframework.stereotype.Service;

@Service 
public class ContaCorrenteService {
    public ContaCorrente realizarSaque(BigDecimal valor, ContaCorrente contaCorrente) {
        contaCorrente.setSaldo(contaCorrente.getSaldo().subtract(valor));
        return contaCorrente;
    }
}
