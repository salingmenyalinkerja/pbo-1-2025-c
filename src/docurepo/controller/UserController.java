package docurepo.controller;

import docurepo.model.User;

public class UserController {
    public static boolean IsUserValid(User user){
        String username = "admin";
        String password = "admin";
        return
            user.GetUsername().equals(username) &&
            user.GetPassword().equals(password);
    }

    public static boolean IsUserValid(String username, String password){
        User user = new User(username, password);
        return IsUserValid(user);
    }
}