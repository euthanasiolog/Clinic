package piatr.asylum.service.peopleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.GenericDAO;
import piatr.asylum.dao.peopleDAO.UserDAOimpl;
import piatr.asylum.service.GenericServiceImpl;
import piatr.asylum.abstractClasses.User;

/**
 * Created by piatr on 31.05.17.
 */
@Service("userService")
@Transactional
public abstract class UserServiceImpl extends GenericServiceImpl<User> implements UserService {
    @Autowired
    private
    UserDAOimpl userDAO;

    @Override
    protected void setGenericDAO(GenericDAO<User> genericDAO)
    {
       super.setGenericDAO(genericDAO);
    }

    @Override
    public User getUserByLogin(String login, String userType) {
        return userDAO.getUserByLogin(login, userType);
    }
}
