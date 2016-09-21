package cl.mockito.sample;


public class User {

    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void changePassword(String newPassword) {
        password = newPassword;
    }

    public boolean checkPassword(String newPassword) {
        return password.equals(newPassword);
    }
}
