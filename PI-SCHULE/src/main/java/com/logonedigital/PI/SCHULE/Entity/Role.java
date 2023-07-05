package com.logonedigital.PI.SCHULE.Entity;

import com.logonedigital.PI.SCHULE.Enumeration.RoleName;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_roles")
@Entity
public class Role implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    private Integer idRole;
    @Enumerated
    @NotNull
    private RoleName nomRole;
}
