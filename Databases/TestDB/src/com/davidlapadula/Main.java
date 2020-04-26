package com.davidlapadula;

import java.sql.*;

public class Main {
    public static final String DB_NAME = "test.db";
    public static final String CONN_STRING = "jdbc:sqlite:C:\\Users\\DavidLapadula\\Downloads\\" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

	    try {
            Connection conn = DriverManager.getConnection(CONN_STRING);
            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS "
                                 + TABLE_CONTACTS +
                                 " (" + COLUMN_NAME + " text, " +
                                        COLUMN_PHONE + " integer, " +
                                        COLUMN_EMAIL +  "text )"
                        );
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('John', 54321, 'john@email.com')");
//            statement.execute("UPDATE contacts SET phone = 987654 WHERE name='John'");

//            statement.execute("SELECT * FROM contacts");
//            ResultSet resultSet = statement.getResultSet();

            insertContact(statement, "Mark", 239874, "mark@email.com");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM contacts");
            while(resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getInt("phone"));
                System.out.println(resultSet.getString("email"));
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
	        e.printStackTrace();
        }
    }

    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_CONTACTS + " (" + COLUMN_NAME + ", " + COLUMN_PHONE +  ", " + COLUMN_EMAIL  + ", " + ") "
                             + "VALUES('" + name + "', " + phone + "', " + email +  "')");
    }
}
