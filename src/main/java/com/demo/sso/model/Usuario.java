package com.demo.sso.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

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

    private String token;

    private Date expiry;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    @Override public String toString() {
        return "Usuario{" + "name='" + name + '\'' + ", password='" + password + '\'' + ", enabled="
            + enabled + ", token='" + token + '\'' + ", expiry=" + expiry + '}';
    }
}
