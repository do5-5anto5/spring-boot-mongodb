/** At here, UserDTO and User are totally equals, but DTO allows me transfer only specific data that i
 * need(or want).
 * That is useful for speed and security
 * 
 * October 3rd, 2023
 */

package com.do55anto5.workshopmongo.dto;

import java.io.Serializable;

import com.do55anto5.workshopmongo.domain.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String email;

	public UserDTO() {
		super();
	}

	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
