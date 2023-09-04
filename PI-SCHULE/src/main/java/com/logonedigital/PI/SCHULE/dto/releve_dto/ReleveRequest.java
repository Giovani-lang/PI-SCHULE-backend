package com.logonedigital.PI.SCHULE.dto.releve_dto;

import com.logonedigital.PI.SCHULE.Enumeration.DecisionName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReleveRequest {
    private String module;
//    private String codeMatiere;
    private DecisionName decision;
}
