package com.imonichris.authenticationmicroservice.service;

import java.util.List;

import com.imonichris.authenticationmicroservice.dto.UserDTO;
import com.imonichris.authenticationmicroservice.entity.AppUser;

/**
* @author Chris Imoni (https://github.com/chrisimoni)
* @version 1.0
*/
public interface UserService {
	UserDTO saveUser(AppUser user);
	UserDTO getUser(String email);
	void addRoleToUser(String username, String roleName);
	List<UserDTO> getUsers(int page, int limit);
}
