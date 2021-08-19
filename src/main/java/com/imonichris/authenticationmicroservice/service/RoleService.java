package com.imonichris.authenticationmicroservice.service;

import com.imonichris.authenticationmicroservice.dto.RoleDTO;
import com.imonichris.authenticationmicroservice.entity.Role;

/**
* @author Chris Imoni (https://github.com/chrisimoni)
* @version 1.0
*/
public interface RoleService {
	RoleDTO saveRole(Role role);
}
