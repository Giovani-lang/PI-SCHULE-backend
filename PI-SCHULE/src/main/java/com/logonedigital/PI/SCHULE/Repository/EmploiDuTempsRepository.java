package com.logonedigital.PI.SCHULE.Repository;

import com.logonedigital.PI.SCHULE.Entity.EmploiDuTemps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploiDuTempsRepository extends JpaRepository<EmploiDuTemps, Integer>{
}
