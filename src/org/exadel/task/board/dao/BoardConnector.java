package org.exadel.task.board.dao;

import java.sql.*;

public class BoardConnector {

	private static final String DRIVER_NAME = "org.apache.derby.jdbc.EmbeddedDriver";

	private static final String DEFAULT_DB_NAME = "DefaultBoard";

	public BoardConnector() {
		loadDatabaseDriver();
	}

	private void loadDatabaseDriver() {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	public Connection createConnection() throws SQLException {
		return createConnection(DEFAULT_DB_NAME);
	}
	
	public Connection createConnection(String dbName) throws SQLException {

		final String connectionURL = "jdbc:derby:" + dbName + ";create=true;";

		return DriverManager.getConnection(connectionURL);
	}
	

	public static void main(String[] args) {
		
		final BoardConnector tbd = new BoardConnector();
		Connection dbConnection = null;
		try {
			dbConnection = tbd.createConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
