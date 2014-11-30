package com.musicLibrary.service;

import com.musicLibrary.Beans.User;
import com.musicLibrary.Dao.UserDB;

public class AuthenticationProcess {
	public User loginCheck(String email, String password) {
		User user = null;
		UserDB userDao = new UserDB();
		user = userDao.loginCheck(email, password);
		return user;
	}
}
