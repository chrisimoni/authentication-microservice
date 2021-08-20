package com.imonichris.authenticationmicroservice.service;

import java.util.List;

import com.imonichris.authenticationmicroservice.dto.RoleDTO;
import com.imonichris.authenticationmicroservice.dto.UserDTO;

/**
* @author Chris Imoni (https://github.com/chrisimoni)
* @version 1.0
*/
public interface UserService {
	UserDTO saveUser(UserDTO user);
	UserDTO getUser(String email);
	RoleDTO saveRole(RoleDTO role);
	void addRoleToUser(String username, String roleName);
	List<UserDTO> getUsers(int page, int limit);
}
