package iplocation.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

public class SqlDataService {

	// TODO review carefully the db file settings:

//	1. uncomment this for static hard-coded db file name
	public static final String SQLITE_DATABASE_ABSOLUTE_PATH = "/home/para/workspace/IPLocation/iplocation.db"; // Linux
//	public static final String SQLITE_DATABASE_ABSOLUTE_PATH = "C:/Users/paRa/Desktop/workspace/IPLocation/iplocation.db"; // Windows
	public static final String SQLITE_CONNECTION_STRING = "jdbc:sqlite:" + SQLITE_DATABASE_ABSOLUTE_PATH;

//	2. uncomment this for dynamic db file name set in tomcat server.xml file
//	public static final String SQLITE_DATABASE_ABSOLUTE_PATH_PROPERTY_NAME = "dbFile";
//	public static String SQLITE_DATABASE_ABSOLUTE_PATH = "";
//	public static String SQLITE_CONNECTION_STRING = "";

//	tables constants (make sure they are the same with the one in the db stucture

//	table columns (make sure they are the same with the one in the db structure

//	account table
	public static final String TABLE_ACCOUNTS = "accounts";

//	account columns

	public static final String FIELD_ACCOUNT_ID = "id";
	public static final String FIELD_ACCOUNT_USERNAME = "username";
	public static final String FIELD_ACCOUNT_PASSWORD = "password";
	public static final String FIELD_ACCOUNT_INVITE_CODE = "inviteCode";

	private static Connection connection;

	private void connect() {
		try {

			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(SQLITE_CONNECTION_STRING);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public static void closeQuietly(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				/* ignored */}
		}
	}

	public void executeQuery(String query) throws Exception {
		Statement st;
		try {
			connect();
			st = connection.createStatement();
			st.executeUpdate(query);
		} catch (Exception e) {
			throw e;
		} finally {
			closeQuietly(connection);
		}
	}

	// Accounts

//	public Account getLastAccount() throws Exception {
//
//		String query = "SELECT * FROM " + TABLE_ACCOUNTS + " ORDER BY " + FIELD_ACCOUNT_ID + " DESC LIMIT 1;";
//		System.out.println(query);
//
//		Statement statement;
//		ResultSet resultSet;
//
//		Account a = new Account();
//
//		try {
//
//			connect();
//			statement = connection.createStatement();
//			resultSet = statement.executeQuery(query);
//
//			while (resultSet.next()) {
//				int id = resultSet.getInt(FIELD_ACCOUNT_ID);
//				String username = resultSet.getString(FIELD_ACCOUNT_USERNAME);
//				String password = resultSet.getString(FIELD_ACCOUNT_PASSWORD);
//				a.setId(id);
//				a.setUsername(username);
//				a.setPassword(password);
//			}
//
//		} catch (Exception e) {
//			throw e;
//		} finally {
//			closeQuietly(connection);
//		}
//
//		return a;
//
//	}


}
