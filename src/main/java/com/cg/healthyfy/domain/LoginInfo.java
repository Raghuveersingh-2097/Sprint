package com.cg.healthyfy.domain;

import javax.persistence.*;

import lombok.*;

@Entity
@Setter
@Getter
public class LoginInfo {
	private String password;
@Id	
 int id;
}
