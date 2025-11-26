package docurepo.controller;

import docurepo.model.User;
import docurepo.view.DocumentView;

import java.util.ArrayList;

public class DocumentController {

    private ArrayList<User> users = new ArrayList<>();
    private DocumentView view = new DocumentView();

    public DocumentController() {
        users.add(new User("admin", "admin"));
        users.add(new User("user", "123"));
    }

    public boolean login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) &&
                u.getPassword().equals(password)) {

                view.showMessage("Login berhasil!");
                return true;
            }
        }
        view.showMessage("Login gagal!");
        return false;
    }
}
