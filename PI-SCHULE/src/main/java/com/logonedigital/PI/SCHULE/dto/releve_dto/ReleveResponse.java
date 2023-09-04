package com.logonedigital.PI.SCHULE.dto.releve_dto;

import com.logonedigital.PI.SCHULE.Enumeration.DecisionName;
import com.logonedigital.PI.SCHULE.Model.NoteModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReleveResponse {
    private String module;
    private List<NoteModel> notes;
    private DecisionName decision;
}
