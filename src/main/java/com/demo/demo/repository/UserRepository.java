package com.demo.demo.repository;

import com.demo.demo.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author alain.menchaca on 20/04/18.
 */

public interface UserRepository extends CrudRepository<Usuario, Long> {

    List<Usuario> findByName(String name);

}
