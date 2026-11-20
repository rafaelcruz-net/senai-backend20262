package org.example.bankapisenai.repository;

import org.example.bankapisenai.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}
