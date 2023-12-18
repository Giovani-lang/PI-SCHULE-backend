package com.logonedigital.PI.SCHULE.Repository;

import com.logonedigital.PI.SCHULE.Entity.PensionScolaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PensionScolaireRepo extends JpaRepository<PensionScolaire, Long> {
    @Query("SELECT SUM(p.montant) AS total FROM Paiement p  WHERE p.etudiant.matricule =:m AND p.date BETWEEN CONCAT(SUBSTRING(p.etudiant.anneeAcademique, 1, 4), '-10-01') AND CONCAT(SUBSTRING(p.etudiant.anneeAcademique, 6, 4),'-07-31')  ")
     Double getTotalPaymentForStudent(@Param("m") String matricule);

    @Query(value = "SELECT * FROM `tb_pension_scolaire` WHERE `tb_pension_scolaire`.`matricule_etudiant` =:m",nativeQuery = true)
    Optional<PensionScolaire> findByMatricule(@Param("m") String matricule);
}
