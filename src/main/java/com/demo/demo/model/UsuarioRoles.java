package com.demo.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author alain.menchaca on 20/04/18.
 */
//@Data
@Entity
public class UsuarioRoles {

    @Id
    private String name;

    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override public String toString() {
        return "UsuarioRoles{" + "name='" + name + '\'' + ", role='" + role + '\'' + '}';
    }
}
