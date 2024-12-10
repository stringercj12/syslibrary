package com.jcf.syslibrary.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "tb_roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "role_id")
    private UUID roleId;

    private String name;

    private String description;

    @Getter
    public enum Values {
        BASIC(UUID.randomUUID()),
        ADMIN(UUID.randomUUID());

        UUID roleId;

        Values(UUID roleId) {
            this.roleId = roleId;
        }

    }
}
