package com.logonedigital.PI.SCHULE.Repository;

import com.logonedigital.PI.SCHULE.Entity.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
    Optional<Classe> findByNom (String nom);
}
