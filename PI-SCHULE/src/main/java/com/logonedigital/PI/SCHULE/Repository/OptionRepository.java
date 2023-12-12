package com.logonedigital.PI.SCHULE.Repository;

import com.logonedigital.PI.SCHULE.Entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    Optional<Option> findByNom(String nom);
}
