package org.example.service;

import org.example.TrackUserAction;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@TrackUserAction
	public void userServiceMethod(String text) {
		System.out.println("UserServiceMethod called with User role" );
	}
	public String getText() {
		return "User";
	}
}
