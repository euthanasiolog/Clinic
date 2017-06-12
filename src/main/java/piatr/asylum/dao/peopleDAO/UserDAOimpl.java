package piatr.asylum.dao.peopleDAO;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.abstractClasses.User;
import piatr.asylum.dao.GenericDAOImpl;

/**
 * Created by piatr on 12.06.17.
 */
@Repository("userDAO")
@Transactional
public abstract class UserDAOimpl extends GenericDAOImpl<User> implements UserDAO {
    @Autowired
    private
    SessionFactory sessionFactory;
    @Override
    public User getUserByLogin(String login, String userType) {
        String doctorHQL = "FROM :userType WHERE login = :login";
        Query query = sessionFactory.getCurrentSession().createQuery(doctorHQL);
        query.setParameter("login", login);
        query.setParameter("userType", userType);
        return (User) query.uniqueResult();
    }
}
