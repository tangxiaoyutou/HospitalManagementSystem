package dao;

import java.sql.Connection;

import util.DatabaseUtil;

public class Database {
	public Connection connection = new DatabaseUtil().getConnection();
	
}
