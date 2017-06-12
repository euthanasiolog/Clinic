package piatr.asylum.service.peopleService;

import piatr.asylum.abstractClasses.User;
import piatr.asylum.service.GenericService;

/**
 * Created by piatr on 31.05.17.
 */
public interface UserService<T extends User> extends GenericService<T> {
    public User getUserByLogin(String login, String type);
    public boolean isLoginExist(String login, String userType);
    public boolean isPasswordCorrect(String login, String password, String userType);
}
