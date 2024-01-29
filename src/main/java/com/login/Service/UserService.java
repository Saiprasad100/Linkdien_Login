package com.login.Service;

import com.login.Dto.LoginDTO;
import com.login.Dto.UserDTO;
import com.login.response.LoginResponse;

public interface UserService {

	String addUser(UserDTO userDTO);
	LoginResponse loginUser(LoginDTO loginDTO);
}
