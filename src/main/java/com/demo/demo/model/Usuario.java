package com.demo.demo.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author alain.menchaca on 20/04/18.
 */
//@Data
@Entity
public class Usuario {

    @Id
    private String name;

    private String password;

    private Boolean enabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override public String toString() {
        return "Usuario{" + "name='" + name + '\'' + ", password='" + password + '\'' + ", enabled="
            + enabled + '}';
    }
}
