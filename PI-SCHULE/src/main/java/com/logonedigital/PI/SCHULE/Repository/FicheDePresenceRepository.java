package com.logonedigital.PI.SCHULE.Repository;

import com.logonedigital.PI.SCHULE.Entity.FicheDePresence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FicheDePresenceRepository extends JpaRepository<FicheDePresence,String> {
    Optional<FicheDePresence> findByMatricule(String matricule);
    Optional<FicheDePresence> findByNomComplet(String nomComplet);
}
