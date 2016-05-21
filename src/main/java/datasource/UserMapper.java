/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.sql.Connection;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author Simon
 */
public class UserMapper {

    Connection con;

    public UserMapper(Connection con) {
        this.con = con;
    }

    public ArrayList<User> getAllUsers() {
        return null;
    }

}
