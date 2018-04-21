package com.demo.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author alain.menchaca on 20/04/18.
 */
@Data
@Entity
public class UsuarioRoles {

    @Id
    private String name;

    private String role;

}
