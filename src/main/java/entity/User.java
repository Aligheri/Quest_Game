package entity;

public class User {
    private final String username;

    public User(String ignoredUsername) {
        this.username = ignoredUsername;
    }

    public String getUsername() {
        return username;
    }

}
