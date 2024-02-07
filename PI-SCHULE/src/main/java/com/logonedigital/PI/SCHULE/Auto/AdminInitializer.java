package com.logonedigital.PI.SCHULE.Auto;

import com.logonedigital.PI.SCHULE.Entity.Administration;
import com.logonedigital.PI.SCHULE.Mapper.AdminMapper;
import com.logonedigital.PI.SCHULE.Repository.AdminRepo;
import com.logonedigital.PI.SCHULE.dto.admin_dto.AdminRequestDTO;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@RequiredArgsConstructor
public class AdminInitializer {

    private final PasswordEncoder encoder;
    private final  AdminRepo adminRepo;
    private final AdminMapper adminMapper;

@PostConstruct
public void init() {
    long count = adminRepo.countByAdmins();
    if (count == 0) {
        AdminRequestDTO admin = new AdminRequestDTO(
                "admin@gmail.com",
                null,
                "Admin",
                "Admin",
                this.encoder.encode("admin"),
                "000000000",
                "M"
        );
        Administration adminSaved = this.adminMapper.fromAdminRequestDTO(admin);
        adminSaved.setRole("ADMIN");
        adminSaved.setCreatedAt(new Date());
        this.adminRepo.save(adminSaved);
    }
}
}
