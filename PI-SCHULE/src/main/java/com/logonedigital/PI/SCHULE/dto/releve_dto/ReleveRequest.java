package com.logonedigital.PI.SCHULE.dto.releve_dto;

import com.logonedigital.PI.SCHULE.Enumeration.DecisionName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReleveRequest {
    private String module;
    private String nomMatiere;
    private DecisionName decision;
}
