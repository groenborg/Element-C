package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author Simon
 */
public class UserMapper implements IMapper {

    private Connection con;
    private ArrayList<User> users;

    public UserMapper(Connection con) {
        this.con = con;
    }

    public ArrayList<User> getAllUsers() {
        users = new ArrayList();
        PreparedStatement statement;
        String selectUsers = "SELECT * FROM user";

        try {
            statement = con.prepareStatement(selectUsers);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                users.add(new User(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return users;
    }
}
