package com.logonedigital.PI.SCHULE.Repository;

import com.logonedigital.PI.SCHULE.Entity.Tarif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TarifRepository extends JpaRepository<Tarif, Long> {
    @Query(value = "SELECT montant FROM `tb_tarifs` WHERE `tb_tarifs`.`niveau` =:n AND `tb_tarifs`.`options_id` =:o",nativeQuery = true)
    double findTarifByNiveauAndOptions(@Param("n") String niveau,@Param("o") Long option_id);
     @Query(value = "UPDATE tb_classes INNER JOIN tb_tarifs ON tb_classes.niveau = tb_tarifs.niveau " +
             "AND tb_classes.option_id = tb_tarifs.options_id" +
             "SET tb_classes.tarif = tb_tarifs.montant",nativeQuery = true)
    void updateTarif();
}
