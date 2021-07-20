package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Patient;
import model.User;
import util.StringUtil;
import util.UserUtil;

public class UserDao extends Database {
	/* 用户登录 */
	public User checkForUser(User user) {
		String sql = "select * from USERS where USER_ID_NO = ? and USER_PSWD = ?";
		User us = null;
		if (user != null) {
			try {
				PreparedStatement prStatement = connection.prepareStatement(sql);
				prStatement.setString(1, user.getId());
				prStatement.setString(2, user.getPassword());
				ResultSet executeQuery = prStatement.executeQuery();
				if (executeQuery.next()) {
					us = new User();
					us.setId(executeQuery.getString(1));
					us.setPassword(executeQuery.getString(2));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return us;
	}

	public User referUserPersonalInformation(User user) {
		User us = null;
		if (UserUtil.isUser(user)) {
			try {
				String sql = "select * from PERSONNEL where EMP_NO = ?";
				PreparedStatement prStatement = connection.prepareStatement(sql);
				prStatement.setString(1, user.getId());
				ResultSet executeQuery = prStatement.executeQuery();
				if (executeQuery.next()) {
					us = new User();
					us.setId(executeQuery.getString(1));
					us.setName(executeQuery.getString(2));
					us.setDeptId(executeQuery.getString(3));
					us.setDuty(executeQuery.getString(4));
					us.setEduBaXl(executeQuery.getString(5));
					us.setGender(executeQuery.getString(6));
					us.setBirthdayString(executeQuery.getString(7));
					us.setHomeString(executeQuery.getString(8));
					us.setCountryString(executeQuery.getString(9));
					us.setNationString(executeQuery.getString(10));
					us.setCitizenId(executeQuery.getString(11));
					us.setMarriage(executeQuery.getString(12));
					us.setHealthString(executeQuery.getString(13));
					us.setStartWorkString(executeQuery.getString(14));
					us.setStateString(executeQuery.getString(15));
					us.setHomeAddressString(executeQuery.getString(16));
					us.setTeleNoString(executeQuery.getString(17));
					us.seteMailString(executeQuery.getString(18));
					us.setJobIdString(executeQuery.getString(19));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return us;
		}
		return user;
	}

	public List<User> getAllUserInformation() {
		List<User> userList = new ArrayList<>();
		try {
			String sql = "select * from PERSONNEL";
			PreparedStatement prStatement = connection.prepareStatement(sql);
			ResultSet executeQuery = prStatement.executeQuery();
			while (executeQuery.next()) {
				User user = new User();
				user.setId(executeQuery.getString("EMP_NO"));
				user.setName(executeQuery.getString("EMP_NAME"));
				user.setDeptId(executeQuery.getString("EMP_DEPT_ID"));
				user.setDuty(executeQuery.getString("EMP_DUTY"));
				user.setEduBaXl(executeQuery.getString("EMP_XL"));
				user.setGender(executeQuery.getString("EMP_GENDER"));
				user.setBirthdayString(executeQuery.getString("EMP_BIRTHDAY"));
				user.setHomeString(executeQuery.getString("EMP_HOMETOWN"));
				user.setCountryString(executeQuery.getString("EMP_COUNTRY"));
				user.setNationString(executeQuery.getString("EMP_NATION"));
				user.setCitizenId(executeQuery.getString("EMP_ID"));
				user.setMarriage(executeQuery.getString("EMP_MARRIAGE"));
				user.setHealthString(executeQuery.getString("EMP_HEALTH"));
				user.setStartWorkString(executeQuery.getString("EMP_STARTWORK"));
				user.setStateString(executeQuery.getString("EMP_STATE"));
				user.setHomeAddressString(executeQuery.getString("EMP_HOMEADDRESS"));
				user.setTeleNoString(executeQuery.getString("EMP_TELENO"));
				user.seteMailString(executeQuery.getString("EMP_EMAIL"));
				user.setJobIdString(executeQuery.getString("EMP_JOB_ID"));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	public List<User> getSomeUserInformation(String name) {
		List<User> userList = new ArrayList<>();
		try {
			String sql = "select * from PERSONNEL where EMP_NAME = ?";
			PreparedStatement prStatement = connection.prepareStatement(sql);
			prStatement.setString(1, name);
			ResultSet executeQuery = prStatement.executeQuery();
			while (executeQuery.next()) {
				User user = new User();
				user.setId(executeQuery.getString("EMP_NO"));
				user.setName(executeQuery.getString("EMP_NAME"));
				user.setDeptId(executeQuery.getString("EMP_DEPT_ID"));
				user.setDuty(executeQuery.getString("EMP_DUTY"));
				user.setEduBaXl(executeQuery.getString("EMP_XL"));
				user.setGender(executeQuery.getString("EMP_GENDER"));
				user.setBirthdayString(executeQuery.getString("EMP_BIRTHDAY"));
				user.setHomeString(executeQuery.getString("EMP_HOMETOWN"));
				user.setCountryString(executeQuery.getString("EMP_COUNTRY"));
				user.setNationString(executeQuery.getString("EMP_NATION"));
				user.setCitizenId(executeQuery.getString("EMP_ID"));
				user.setMarriage(executeQuery.getString("EMP_MARRIAGE"));
				user.setHealthString(executeQuery.getString("EMP_HEALTH"));
				user.setStartWorkString(executeQuery.getString("EMP_STARTWORK"));
				user.setStateString(executeQuery.getString("EMP_STATE"));
				user.setHomeAddressString(executeQuery.getString("EMP_HOMEADDRESS"));
				user.setTeleNoString(executeQuery.getString("EMP_TELENO"));
				user.seteMailString(executeQuery.getString("EMP_EMAIL"));
				user.setJobIdString(executeQuery.getString("EMP_JOB_ID"));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	public User getOneUserInformation(String name) {
		User user = null;
		try {
			String sql = "select * from PERSONNEL where EMP_NAME = ?";
			PreparedStatement prStatement = connection.prepareStatement(sql);
			prStatement.setString(1, name);
			ResultSet executeQuery = prStatement.executeQuery();
			if (executeQuery.next()) {
				user = new User();
				user.setId(executeQuery.getString("EMP_NO"));
				user.setName(executeQuery.getString("EMP_NAME"));
				user.setDeptId(executeQuery.getString("EMP_DEPT_ID"));
				user.setDuty(executeQuery.getString("EMP_DUTY"));
				user.setEduBaXl(executeQuery.getString("EMP_XL"));
				user.setGender(executeQuery.getString("EMP_GENDER"));
				user.setBirthdayString(executeQuery.getString("EMP_BIRTHDAY"));
				user.setHomeString(executeQuery.getString("EMP_HOMETOWN"));
				user.setCountryString(executeQuery.getString("EMP_COUNTRY"));
				user.setNationString(executeQuery.getString("EMP_NATION"));
				user.setCitizenId(executeQuery.getString("EMP_ID"));
				user.setMarriage(executeQuery.getString("EMP_MARRIAGE"));
				user.setHealthString(executeQuery.getString("EMP_HEALTH"));
				user.setStartWorkString(executeQuery.getString("EMP_STARTWORK"));
				user.setStateString(executeQuery.getString("EMP_STATE"));
				user.setHomeAddressString(executeQuery.getString("EMP_HOMEADDRESS"));
				user.setTeleNoString(executeQuery.getString("EMP_TELENO"));
				user.seteMailString(executeQuery.getString("EMP_EMAIL"));
				user.setJobIdString(executeQuery.getString("EMP_JOB_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public User getUserInformation(String id) {
		User user = null;
		try {
			String sql = "select * from PERSONNEL where EMP_NO = ?";
			PreparedStatement prStatement = connection.prepareStatement(sql);
			prStatement.setString(1, id);
			ResultSet executeQuery = prStatement.executeQuery();
			if (executeQuery.next()) {
				user = new User();
				user.setId(executeQuery.getString("EMP_NO"));
				user.setName(executeQuery.getString("EMP_NAME"));
				user.setDeptId(executeQuery.getString("EMP_DEPT_ID"));
				user.setDuty(executeQuery.getString("EMP_DUTY"));
				user.setEduBaXl(executeQuery.getString("EMP_XL"));
				user.setGender(executeQuery.getString("EMP_GENDER"));
				user.setBirthdayString(executeQuery.getString("EMP_BIRTHDAY"));
				user.setHomeString(executeQuery.getString("EMP_HOMETOWN"));
				user.setCountryString(executeQuery.getString("EMP_COUNTRY"));
				user.setNationString(executeQuery.getString("EMP_NATION"));
				user.setCitizenId(executeQuery.getString("EMP_ID"));
				user.setMarriage(executeQuery.getString("EMP_MARRIAGE"));
				user.setHealthString(executeQuery.getString("EMP_HEALTH"));
				user.setStartWorkString(executeQuery.getString("EMP_STARTWORK"));
				user.setStateString(executeQuery.getString("EMP_STATE"));
				user.setHomeAddressString(executeQuery.getString("EMP_HOMEADDRESS"));
				user.setTeleNoString(executeQuery.getString("EMP_TELENO"));
				user.seteMailString(executeQuery.getString("EMP_EMAIL"));
				user.setJobIdString(executeQuery.getString("EMP_JOB_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public boolean isHavePassword(String id) {
		String sqlString = "select USER_PSWD from USERS where USER_ID_NO = ?";
		String passwordString = null;
		try {
			PreparedStatement pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1, id);
			ResultSet set = pStatement.executeQuery();
			if(set.next()) {
				passwordString = set.getString("USER_PSWD");
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(StringUtil.isEmpty(passwordString))
			return false;
		return true;
	}
	public String referDeptNameDept(String deptId) {
		String sqlString = "select DEPT_NAME from DEPT where DEPT_ID = ?";
		String deptNameString = null;
		try {
			PreparedStatement pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1, deptId);
			ResultSet set = pStatement.executeQuery();
			if (set.next()) {
				deptNameString = set.getString("DEPT_NAME");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deptNameString;
	}

	public String referDeptIdDept(String deptName) {
		String sqlString = "select DEPT_ID from DEPT where DEPT_NAME = ?";
		String deptId = null;
		try {
			PreparedStatement pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1, deptName);
			ResultSet set = pStatement.executeQuery();
			if (set.next()) {
				deptId = set.getString("DEPT_ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deptId;
	}

	public String referJobIdDept(String JobName) {
		String sqlString = "select JOB_ID from JOB where JOB_NAME = ?";
		String JobId = null;
		try {
			PreparedStatement pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1, JobName);
			ResultSet set = pStatement.executeQuery();
			if (set.next()) {
				JobId = set.getString("JOB_ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (JobId != null)
			JobId.trim();
		return JobId;
	}

	public String referDeptManagerDept(String deptName) {
		String sqlString = "select DEPT_MANAGER from DEPT where DEPT_NAME = ?";
		String deptManager = null;
		try {
			PreparedStatement pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1, deptName);
			ResultSet set = pStatement.executeQuery();
			if (set.next()) {
				deptManager = set.getString("DEPT_MANAGER");
			}
			// System.out.println("referManager" + deptManager);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (deptManager != null)
			deptManager = deptManager.trim();
		return deptManager;
	}

	public String referDeptViceManagerDept(String name) {
		String sqlString = "select DEPT_VICEMANAGER from DEPT where DEPT_NAME = ?";
		String deptViceManager = null;
		try {
			PreparedStatement pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1, name);
			ResultSet set = pStatement.executeQuery();
			if (set.next()) {
				deptViceManager = set.getString("DEPT_VICEMANAGER");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (deptViceManager != null)
			deptViceManager = deptViceManager.trim();
		return deptViceManager;
	}

	public void updateDeptViceManagerDept(String deptViceManager, String deptName) {
		String sqlString = "update DEPT set DEPT_VICEMANAGER = ? where DEPT_NAME = ?";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1, deptViceManager);
			pStatement.setString(2, deptName);
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateDeptManagerDept(String deptManager, String deptName) {
		String sqlString = "update DEPT set DEPT_MANAGER = ? where DEPT_NAME = ?";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1, deptManager);
			pStatement.setString(2, deptName);
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateUserDeptDutyJobInformation(User user) {
		String sqlString = "update PERSONNEL set EMP_DEPT_ID = ?, EMP_DUTY = ?, EMP_JOB_ID = ? where EMP_NAME = ?";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1, user.getDeptId());
			pStatement.setString(2, user.getDuty());
			pStatement.setString(3, user.getJobIdString());
			pStatement.setString(4, user.getName());
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateUserInformation(User user) {
		String sqlString = "update PERSONNEL set EMP_NO = ?, EMP_NAME = ?, EMP_DEPT_ID = ?, EMP_DUTY = ?, "
				+ "EMP_XL = ?, EMP_GENDER = ?, EMP_BIRTHDAY = ?, EMP_HOMETOWN = ?, EMP_COUNTRY = ?, EMP_NATION = ?, EMP_ID = ?,"
				+ " EMP_MARRIAGE = ?, EMP_HEALTH = ?, EMP_STARTWORK = ?, EMP_STATE = ?, EMP_HOMEADDRESS = ?, EMP_TELENO = ?,"
				+ " EMP_EMAIL = ?, EMP_JOB_ID = ? where EMP_NO = ?";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1, user.getId());
			pStatement.setString(2, user.getName());
			pStatement.setString(3, user.getDeptId());
			pStatement.setString(4, user.getDuty());
			pStatement.setString(5, user.getEduBaXl());
			pStatement.setString(6, user.getGender());
			pStatement.setString(7, user.getBirthdayString());
			pStatement.setString(8, user.getHomeString());
			pStatement.setString(9, user.getCountryString());
			pStatement.setString(10, user.getNationString());
			pStatement.setString(11, user.getCitizenId());
			pStatement.setString(12, user.getMarriage());
			pStatement.setString(13, user.getHealthString());
			pStatement.setString(14, user.getStartWorkString());
			pStatement.setString(15, user.getStateString());
			pStatement.setString(16, user.getHomeAddressString());
			pStatement.setString(17, user.getTeleNoString());
			pStatement.setString(18, user.geteMailString());
			pStatement.setString(19, user.getJobIdString());
			pStatement.setString(20, user.getId());
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertUsersIdPssword(User user) {
		String sqlString = "insert into USERS(USER_ID_NO, USER_PSWD) values(?, ?)";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1, user.getId());
			pStatement.setString(2, user.getPassword());
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updatePassword(User user) {
		String sqlString = "update USERS set USER_PSWD = ? where USER_ID_NO = ?";
		
		try {
			PreparedStatement pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1, user.getPassword());
			pStatement.setString(2, user.getId());
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertUserInformation(User user) {
		String sqlString = "insert into PERSONNEL(EMP_NO, EMP_NAME, EMP_DEPT_ID, EMP_DUTY, "
				+ "EMP_XL, EMP_GENDER, EMP_BIRTHDAY, EMP_HOMETOWN, EMP_COUNTRY, EMP_NATION, EMP_ID,"
				+ " EMP_MARRIAGE, EMP_HEALTH, EMP_STARTWORK, EMP_STATE, EMP_HOMEADDRESS, EMP_TELENO, EMP_EMAIL, EMP_JOB_ID) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1, user.getId());
			pStatement.setString(2, user.getName());
			pStatement.setString(3, user.getDeptId());
			pStatement.setString(4, user.getDuty());
			pStatement.setString(5, user.getEduBaXl());
			pStatement.setString(6, user.getGender());
			pStatement.setString(7, user.getBirthdayString());
			pStatement.setString(8, user.getHomeString());
			pStatement.setString(9, user.getCountryString());
			pStatement.setString(10, user.getNationString());
			pStatement.setString(11, user.getCitizenId());
			pStatement.setString(12, user.getMarriage());
			pStatement.setString(13, user.getHealthString());
			pStatement.setString(14, user.getStartWorkString());
			pStatement.setString(15, user.getStateString());
			pStatement.setString(16, user.getHomeAddressString());
			pStatement.setString(17, user.getTeleNoString());
			pStatement.setString(18, user.geteMailString());
			pStatement.setString(19, user.getJobIdString());
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteUser(String name) {
		String sqlString = "delete from PERSONNEL where EMP_NAME = ?";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1, name);
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
