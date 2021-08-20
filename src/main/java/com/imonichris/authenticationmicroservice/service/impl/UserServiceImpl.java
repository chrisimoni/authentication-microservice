package com.imonichris.authenticationmicroservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imonichris.authenticationmicroservice.dto.RoleDTO;
import com.imonichris.authenticationmicroservice.dto.UserDTO;
import com.imonichris.authenticationmicroservice.entity.AppUser;
import com.imonichris.authenticationmicroservice.entity.Role;
import com.imonichris.authenticationmicroservice.repository.RoleRepository;
import com.imonichris.authenticationmicroservice.repository.UserRepository;
import com.imonichris.authenticationmicroservice.service.UserService;
import com.imonichris.authenticationmicroservice.util.Utils;

/**
 * @author Chris Imoni (https://github.com/chrisimoni)
 * @version 1.0
 */
@Service
@Transactional
//@Slf4j
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private Utils utils;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDTO saveUser(UserDTO userDTO) {
		AppUser appUser = modelMapper.map(userDTO, AppUser.class);

		String publicUserId = utils.generateRandomString();

		appUser.setUserId(publicUserId);
		appUser.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
		AppUser savedUser = userRepository.save(appUser);

		UserDTO returnValue = modelMapper.map(savedUser, UserDTO.class);

		return returnValue;
	}

	@Override
	public UserDTO getUser(String email) {
		AppUser appUser = userRepository.findByEmail(email);

		if (appUser == null)
			throw new UsernameNotFoundException(email);

		UserDTO userDTO = modelMapper.map(appUser, UserDTO.class);

		return userDTO;
	}

	@Override
	public RoleDTO saveRole(RoleDTO roleDTO) {
		Role role = modelMapper.map(roleDTO, Role.class);
		Role savedRole = roleRepository.save(role);
		RoleDTO returnValue = modelMapper.map(savedRole, RoleDTO.class);
		
		return returnValue;
	}

	@Override
	public void addRoleToUser(String email, String roleName) {
		AppUser user = userRepository.findByEmail(email);
		Role role = roleRepository.findByName(roleName);
		user.getRoles().add(role);
	}

	@Override
	public List<UserDTO> getUsers(int page, int limit) {
		List<UserDTO> userDTOs = new ArrayList<>();

		if (page > 0)
			page = page - 1;

		Pageable PageableReuest = PageRequest.of(page, limit);
		Page<AppUser> usersPage = userRepository.findAll(PageableReuest);

		List<AppUser> users = usersPage.getContent();
		users.stream().forEach(user -> {
			UserDTO userDTo = modelMapper.map(user, UserDTO.class);
			userDTOs.add(userDTo);
		});

		return userDTOs;
	}

}
