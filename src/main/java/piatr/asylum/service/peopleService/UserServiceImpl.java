package piatr.asylum.service.peopleService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.service.GenericServiceImpl;
import piatr.asylum.abstractClasses.User;

/**
 * Created by piatr on 31.05.17.
 */
@Service
@Transactional
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {
    @Override
    public User getUserByLogin(String login) {

        return null;
    }
}
