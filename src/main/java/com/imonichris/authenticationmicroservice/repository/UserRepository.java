package com.imonichris.authenticationmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imonichris.authenticationmicroservice.entity.AppUser;
import com.imonichris.authenticationmicroservice.entity.Role;

/**
 * @author Chris Imoni (https://github.com/chrisimoni)
 * @version 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
	AppUser findByEmail(String email);
	AppUser findByUserId(String userId);
}
