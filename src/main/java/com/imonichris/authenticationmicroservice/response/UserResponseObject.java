package com.imonichris.authenticationmicroservice.response;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;
/**
* @author Chris Imoni (https://github.com/chrisimoni)
* @version 1.0
*/
@Setter
@Getter
public class UserResponseObject {
	private Long id;
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private Collection<RoleResponseObject> roles;
}
