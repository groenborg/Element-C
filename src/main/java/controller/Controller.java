package controller;

import java.sql.Connection;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author Simon
 */
public class Controller implements IController {

    public Controller(Connection con) {

    }

    @Override
    public ArrayList<User> getAllEntities() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addToEntity(int userId, int score) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
