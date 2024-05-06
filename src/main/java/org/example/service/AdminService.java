package org.example.service;

import org.example.TrackUserAction;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@TrackUserAction
	public void adminServiceMethod(String text) {
		System.out.println("AdminServiceMethod called with Admin role" );
	}
	public String getText() {
		return "Admin";
	}
}
