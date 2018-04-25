package com.demo.demo.repository;

import com.demo.demo.model.UsuarioRoles;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author alain.menchaca on 24/04/18.
 */

public interface UserRolesRepository extends CrudRepository<UsuarioRoles, Long> {

    List<UsuarioRoles> findByName(String name);
}
