package com.logonedigital.PI.SCHULE.Entity;

import com.logonedigital.PI.SCHULE.Enumeration.RoleName;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private static final Long serialVersion =1L;
    @Id
    private Integer idRole;
    @Enumerated
    private RoleName nomRole;
}
