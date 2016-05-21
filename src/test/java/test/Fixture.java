/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Simon
 */
public class Fixture {

    private Connection con;

    public Fixture(Connection con) {
        this.con = con;
    }

    public void runScript() throws SQLException {
        try {
            con.setAutoCommit(false);
            dropTable();
            createTable();
            insertUsers();
            con.commit();
        } catch (SQLException ex) {
            con.close();
        }
    }

    public void createTable() {
        String createTable = "CREATE TABLE user(user_id INT, user_name VARCHAR(100), score INT, uuid VARCHAR(36), PRIMARY KEY (user_id));";
        Statement statement;
        try {
            statement = con.createStatement();
            statement.execute(createTable);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void insertUsers() {

        Statement statement = null;
        String[] insertUser = new String[8];

        insertUser[0] = "insert into user values(1,'simon',32,'')";
        insertUser[1] = "insert into user values(1,'simon',32,'')";
        insertUser[2] = "insert into user values(1,'simon',32,'')";
        insertUser[3] = "insert into user values(1,'simon',32,'')";
        insertUser[4] = "insert into user values(1,'simon',32,'')";
        insertUser[5] = "insert into user values(1,'simon',32,'')";
        insertUser[6] = "insert into user values(1,'simon',32,'')";

        for (String dt : insertUser) {
            try {
                statement = con.createStatement();
                statement.execute(dt);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

    }

    public void dropTable() {
        String dropTable = "DROP TABLE user";
        Statement statement;
        try {
            statement = con.createStatement();
            statement.execute(dropTable);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
