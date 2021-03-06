package piatr.asylum.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import piatr.asylum.abstractClasses.User;
import piatr.asylum.dao.GenericDAO;

/**
 * Created by piatr on 06.06.17.
 */

public interface UserDAO<T extends User> extends GenericDAO<T>{
    public User getUserByLogin(String login, String userType);
    public boolean isLoginExist(String login, String userType);
    public boolean isPasswordCorrect(String login, String password, String userType);
}
