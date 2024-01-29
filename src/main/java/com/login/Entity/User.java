package com.login.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@Column(name = "user_id", length = 50)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@Column(name = "user_name", length = 250)
	private String userName;

	@Column(name = "email", length = 250)
	private String email;

	@Column(name = "password", length = 250)
	private String password;

}
