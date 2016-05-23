/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Simon
 */
public class Environment {

    // IT's a really bad idea to have credentials here
    // don't ever do it! I will probably get scolded for this   
    public String url = "";
    public String username = "";
    public String password = "";
    private String timeZoneFix = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public boolean ci, drone;

    public Environment() {
        ci = false;
        drone = false;
        try {
            ci = System.getenv("CI").equalsIgnoreCase("true");
            drone = System.getenv("DRONE").equalsIgnoreCase("true");
        } catch (SecurityException | NullPointerException x) {

        }

        if (ci && drone) {
            //CI Build
            url = "jdbc:mysql://127.0.0.1:3306/cidb";
            username = "root";
            password = "";

        } else {
            //local env
            url = "jdbc:mysql://localhost:8889/cidb" + timeZoneFix;
            username = "root";
            password = "root";
        }
    }

}
