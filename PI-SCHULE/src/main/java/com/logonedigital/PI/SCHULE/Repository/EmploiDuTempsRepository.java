package com.logonedigital.PI.SCHULE.Repository;

import com.logonedigital.PI.SCHULE.Entity.EmploiDuTemps;
import com.logonedigital.PI.SCHULE.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmploiDuTempsRepository extends JpaRepository<EmploiDuTemps, Long> {
    Optional<EmploiDuTemps> findByClasse(String classe);
}
