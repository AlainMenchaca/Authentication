package com.demo.demo.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author alain.menchaca on 20/04/18.
 */
@Data
@Entity
public class Usuario {

    @Id
    private String name;

    private String password;

    private int enabled;

}
