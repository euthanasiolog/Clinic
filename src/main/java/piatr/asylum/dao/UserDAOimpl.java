package piatr.asylum.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.abstractClasses.User;

import java.util.List;

/**
 * Created by piatr on 12.06.17.
 */
//@Repository("userDAO")
@Transactional
public class UserDAOimpl<T extends User> extends GenericDAOImpl<T> implements UserDAO<T> {
    @Autowired
    private
    SessionFactory sessionFactory;

//    private final Class<T> entityClass;
//
//    public UserDAOimpl() {
//        Type type = getClass().getGenericSuperclass();
//        ParameterizedType parameterizedType = (ParameterizedType) type;
//        entityClass = (Class) parameterizedType.getActualTypeArguments()[0];
//    }

    @Override
    public User getUserByLogin(String login, String userType) {
        String doctorHQL = "FROM :userType WHERE login = :login";
        Query query = sessionFactory.getCurrentSession().createQuery(doctorHQL);
        query.setParameter("login", login);
        query.setParameter("userType", userType);
        return (User) query.uniqueResult();
    }
    @Override
    public boolean isLoginExist(String login, String userType){
        return  getUserByLogin(login, userType)!=null;
    }

    @Override
    public boolean isPasswordCorrect(String login, String password, String userType) {
        return getUserByLogin(login, userType).getPassword().equals(password);
    }
}
