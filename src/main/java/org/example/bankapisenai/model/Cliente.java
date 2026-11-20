package org.example.bankapisenai.model;

import jakarta.persistence.Entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter 
@Setter 
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column 
    private String nome;

    @Column 
    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<ContaCorrente> contas;
}
