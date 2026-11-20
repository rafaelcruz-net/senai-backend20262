package org.example.bankapisenai.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter @Setter 
public class ContaCorrente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column 
    private String agencia;

    @Column 
    private String numero;

    @Column 
    private BigDecimal saldo;

    @ManyToOne 
    @JoinColumn(name = "id_cliente")
    @JsonIgnore 
    private Cliente cliente;
    
}
