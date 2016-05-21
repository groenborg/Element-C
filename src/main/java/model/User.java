package model;

/**
 *
 * @author Simon
 */
public class User {

    private final int userId;
    private final String name;
    private final String uuid;
    private int score;

    public User(int userId, String name, String uuid, int score) {
        this.userId = userId;
        this.name = name;
        this.uuid = uuid;
        this.score = score;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "id: " + this.userId + " uuid: " + this.uuid + " name: "
                + this.name + " score: " + this.score;
    }

}
