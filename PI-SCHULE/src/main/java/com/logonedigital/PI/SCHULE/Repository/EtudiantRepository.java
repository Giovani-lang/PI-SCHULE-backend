package com.logonedigital.PI.SCHULE.Repository;

import com.logonedigital.PI.SCHULE.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, String> {
    Optional<Etudiant> findByEmail(String email);
    Optional<Etudiant> findByMatricule(String matricule);
    Optional<Etudiant> findByTelephone(String telephone);
    @Query(value = "SELECT e FROM Etudiant e WHERE e.classe.nom = :c")
    List<Etudiant> findAllByClasse (@Param("c") String nomClasse);
}
