package asylum.service.peopleService;

import asylum.abstractClasses.User;
import asylum.service.GenericService;

/**
 * Created by piatr on 31.05.17.
 */
public interface UserService extends GenericService<User> {
    public User getUserByLogin(String login);
}
