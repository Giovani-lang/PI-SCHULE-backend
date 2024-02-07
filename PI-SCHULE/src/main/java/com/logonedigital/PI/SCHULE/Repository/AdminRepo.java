package com.logonedigital.PI.SCHULE.Repository;

import com.logonedigital.PI.SCHULE.Entity.Administration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Administration, Long>{
    Optional<Administration>findByEmail(String email);
    Optional<Administration>findByTelephone(String telephone);

    @Query(value = "SELECT COUNT(*) AS user_count FROM `tb_admin`", nativeQuery = true)
    Long countByAdmins ();

}
