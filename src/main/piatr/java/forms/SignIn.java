package java.forms;

/**
 * Created by piatr on 31.05.17.
 */
public class SignIn {
    private String type;
    private String login;
    private String password;

    public SignIn() {
        this.type = "";
        this.login = "";
        this.password = "";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
