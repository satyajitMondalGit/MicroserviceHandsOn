package com.ibm.user.authentication.dto;

import com.ibm.user.authentication.model.User;

public class UserMapper {

	public User convertDTOtoUSER(UserDTO dto) {
		
		User user = new User();
		
		user.setUser(dto.getUser());
		user.setPass(dto.getPass());
		user.setRole(dto.getRole());
		
		return user;
		
	}
	
	public UserDTO convertUSERtoDTO(User user) {
		
		UserDTO dto = new UserDTO();
		
		dto.setUser(user.getUser());
		dto.setPass(user.getPass());
		dto.setRole(user.getRole());
		
		
		return dto;
		
	}
	
}
