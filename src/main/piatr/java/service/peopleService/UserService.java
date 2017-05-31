package java.service.peopleService;

import java.abstractClasses.User;
import java.service.GenericService;

/**
 * Created by piatr on 31.05.17.
 */
public interface UserService extends GenericService<User> {
    public User getUserByLogin(String login);
}
