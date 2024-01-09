package com.logonedigital.PI.SCHULE.Mapper;

import com.logonedigital.PI.SCHULE.Entity.Paiement;
import com.logonedigital.PI.SCHULE.dto.paiement_dto.PaiementRequest;
import com.logonedigital.PI.SCHULE.dto.paiement_dto.PaiementResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")
@Configuration
public interface PaiementMapper {

    Paiement fromPaiementRequest (PaiementRequest paiementRequest);

    @Mapping(source = "etudiant", target = "etudiant")
    @Mapping(source = "anneeAcademique", target = "anneeAcademique")
    PaiementResponse fromPaiement (Paiement paiement);
}
