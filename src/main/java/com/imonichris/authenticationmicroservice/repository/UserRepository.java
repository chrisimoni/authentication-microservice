package com.imonichris.authenticationmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imonichris.authenticationmicroservice.entity.AppUser;

/**
 * @author Chris Imoni (https://github.com/chrisimoni)
 * @version 1.0
 */
public interface UserRepository extends JpaRepository<AppUser, Long> {
	AppUser findByEmail(String email);
	AppUser findByUserId(String userId);
}
