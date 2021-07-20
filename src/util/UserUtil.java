package util;

import dao.UserDao;
import model.User;

public class UserUtil {
	public static User beUser(String id, String password) {
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		UserDao userDao = new UserDao();
		return userDao.checkForUser(user);
	}
	public static User beUser(User user) {
		UserDao userDao = new UserDao();
		if(user != null)
			return userDao.checkForUser(user);
		return null;
	}
	public static boolean isUser(String id, String password) {
		// TODO Auto-generated method stub
		User user = UserUtil.beUser(id, password);
		if(user != null) {
			return true;
		}
		return false;
	}
	public static boolean isUser(User user) {
		User us = UserUtil.beUser(user);
		if(us != null) {
			//System.out.println(user+"不是null");
			return true;
		}
		return false;
	}
}
