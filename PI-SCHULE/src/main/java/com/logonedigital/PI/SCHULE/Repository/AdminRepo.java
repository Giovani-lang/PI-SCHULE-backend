package com.logonedigital.PI.SCHULE.Repository;

import com.logonedigital.PI.SCHULE.Entity.Administration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Administration, String>{
    Optional<Administration>findByEmail(String email);
    Optional<Administration>findByPassword(String password);
    Optional<Administration>findByTéléphone(String téléphone);

}
