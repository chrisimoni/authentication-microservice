package com.imonichris.authenticationmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imonichris.authenticationmicroservice.entity.Role;

/**
 * @author Chris Imoni (https://github.com/chrisimoni)
 * @version 1.0
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String roleName);
}
