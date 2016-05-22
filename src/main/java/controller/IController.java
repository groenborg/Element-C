package controller;

import java.util.ArrayList;
import model.User;

/**
 *
 * @author Simon
 */
public interface IController {

    public ArrayList<User> getAllEntities();

    public void addToEntity(int userId, int score);

}
