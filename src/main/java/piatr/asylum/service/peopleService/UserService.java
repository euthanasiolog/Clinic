package piatr.asylum.service.peopleService;

import piatr.asylum.abstractClasses.User;
import piatr.asylum.service.GenericService;

/**
 * Created by piatr on 31.05.17.
 */
public interface UserService extends GenericService<User> {
    public User getUserByLogin(String login);
}
