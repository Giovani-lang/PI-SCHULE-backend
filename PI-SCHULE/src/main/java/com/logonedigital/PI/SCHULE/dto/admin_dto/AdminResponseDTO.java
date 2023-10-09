package com.logonedigital.PI.SCHULE.dto.admin_dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.logonedigital.PI.SCHULE.Model.EmploiDuTempsModel;
import com.logonedigital.PI.SCHULE.Model.PensionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminResponseDTO {
    private String email;
    private String nom;
    private String prenom;
    private String password;
    private String telephone;
    private String genre;
    private String role;
    private Date createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
    private List<EmploiDuTempsModel> emploiDuTemps;
    private List<PensionModel> pensions;

}
