package com.login.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.Dto.LoginDTO;
import com.login.Dto.UserDTO;
import com.login.Entity.User;
import com.login.Repository.UserRepo;
import com.login.Service.UserService;
import com.login.response.LoginResponse;

@Service
public class UserImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String addUser(UserDTO userDTO) {

		User user = new User(
				userDTO.getUserId(), 
				userDTO.getUserName(), 
				userDTO.getEmail(),
				this.passwordEncoder.encode(userDTO.getPassword()));
		userRepo.save(user);
		return user.getUserName();
	}

	UserDTO employeeDTO;
    @Override
    public LoginResponse  loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> employee = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }
}
	