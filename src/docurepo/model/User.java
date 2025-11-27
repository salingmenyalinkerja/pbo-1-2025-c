package docurepo.model;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String GetUsername() {
        return username;
    }

    public String GetPassword() {
        return password;
    }

    public String ToString(){
        return String.format("%s %s", username, password);
    }
}
