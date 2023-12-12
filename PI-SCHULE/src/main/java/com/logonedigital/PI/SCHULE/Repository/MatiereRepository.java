package com.logonedigital.PI.SCHULE.Repository;

import com.logonedigital.PI.SCHULE.Entity.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Long> {
    Optional<Matiere> findByIntitule (String intitule);
}
