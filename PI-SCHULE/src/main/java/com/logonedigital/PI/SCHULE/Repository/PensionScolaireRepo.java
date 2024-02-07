package com.logonedigital.PI.SCHULE.Repository;

import com.logonedigital.PI.SCHULE.Entity.AnneeAcademique;
import com.logonedigital.PI.SCHULE.Entity.PensionScolaire;
import com.logonedigital.PI.SCHULE.Entity.Tarif;
import com.logonedigital.PI.SCHULE.Model.AnneeAcademiqueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PensionScolaireRepo extends JpaRepository<PensionScolaire, Long> {
    @Query("SELECT SUM(p.montant) AS total FROM Paiement p  WHERE p.etudiant.matricule =:m AND p.anneeAcademique.id =:a ")
     Double getTotalPaymentForStudent(@Param("m") String matricule, @Param("a") Long anneeAcademique);

    @Query(value = "SELECT * FROM `tb_pension_scolaire` WHERE `tb_pension_scolaire`.`matricule_etudiant` =:m AND `tb_pension_scolaire`.`annee_academique_id` =:a",nativeQuery = true)
    Optional<PensionScolaire> findByMatricule(@Param("m") String matricule, @Param("a") Long anneeAcademique);

    @Query(value = "SELECT * FROM `tb_pension_scolaire` WHERE `tb_pension_scolaire`.`annee_academique_id` =:a",nativeQuery = true)
    List<PensionScolaire> findAllByAnnee(@Param("a")Long anneeAcademique);

    @Query(value = "SELECT * FROM `tb_tarifs` WHERE `tb_tarifs`.`niveau` =:n AND `tb_tarifs`.`options_id` =:o",nativeQuery = true)
    double getTarif(@Param("n") String niveau, @Param("o")Long option_id);
}
