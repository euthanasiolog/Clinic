package piatr.asylum.service.peopleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.GenericDAO;
import piatr.asylum.dao.UserDAO;
import piatr.asylum.entity.peopleEntity.users.DoctorEntity;
import piatr.asylum.service.GenericServiceImpl;
import piatr.asylum.abstractClasses.User;

/**
 * Created by piatr on 31.05.17.
 */
@Service("userService")
@Transactional
public class UserServiceImpl<T extends User> extends GenericServiceImpl<T> implements UserService<T> {

    private UserDAO<T> userDAO;

//    @Override
//    protected void setGenericDAO(GenericDAO<T> genericDAO) {
//        super.setGenericDAO(genericDAO);
//    }

    @Override
    public User getUserByLogin(String login, String userType) {
        return userDAO.getUserByLogin(login, userType);
    }

    @Override
    public boolean isLoginExist(String login, String userType){
        return userDAO.isLoginExist(login, userType);
    }

    @Override
    public boolean isPasswordCorrect(String login, String password, String userType) {
        return userDAO.isPasswordCorrect(login, password, userType);
    }

    public void setUserDAO(UserDAO<T> userDAO)
    {
        this.userDAO = userDAO;
    }

    @Override
    public T create(T t) {
        return userDAO.create(t);
    }

    @Override
    public T get(long id) {
        return userDAO.get(id);
    }

    @Override
    public void update(T t) {
        userDAO.update(t);
    }

    @Override
    public void delete(T t) {
        userDAO.delete(t);
    }
}
