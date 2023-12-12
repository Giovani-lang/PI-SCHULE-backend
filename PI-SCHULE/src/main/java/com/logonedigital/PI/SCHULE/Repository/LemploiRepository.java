package com.logonedigital.PI.SCHULE.Repository;

import com.logonedigital.PI.SCHULE.Entity.Lemploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LemploiRepository extends JpaRepository<Lemploi,Long> {
    @Query(value = "SELECT * FROM `tb_ligne_emploi_du_temps`WHERE `tb_ligne_emploi_du_temps`.`classe` =:m",nativeQuery = true)
    List<Lemploi> findByClasse(@Param("m") String classe);
}
