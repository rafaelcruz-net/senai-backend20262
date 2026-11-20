package org.example.bankapisenai.repository;

import org.example.bankapisenai.model.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Integer> {
    
}
