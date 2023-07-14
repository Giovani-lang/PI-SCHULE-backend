package com.logonedigital.PI.SCHULE.Repository;

import com.logonedigital.PI.SCHULE.Entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant,String> {
    Optional<Enseignant> findByEmail(String email);
    Optional<Enseignant> findByMotDePasse(String motDePasse);
    Optional<Enseignant> findByNumeroTel(Integer numeroTel);
}
