package com.logonedigital.PI.SCHULE.Repository;

import com.logonedigital.PI.SCHULE.Entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    @Query(value = "SELECT * FROM `tb_historique_des_paiements` WHERE `tb_historique_des_paiements`.`matricule_etudiant` =:m AND `tb_historique_des_paiements`.`annee_academique_id` =:a ",nativeQuery = true)
    List<Paiement> findPaiementByMatricule(@Param("m") String matricule,@Param("a")Long annee);
}
