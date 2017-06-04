package piatr.asylum.dao;

import piatr.asylum.abstractClasses.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by piatr on 23.05.17.
 */
@Repository("genericDAO")
@Transactional
public class GenericDAOImpl<T extends BaseEntity> implements GenericDAO<T> {

    //private final Class<T> entityClass;

    public GenericDAOImpl() {
//        Type type = getClass().getGenericSuperclass();
//        ParameterizedType parameterizedType = (ParameterizedType) type;
//        entityClass = (Class) parameterizedType.getActualTypeArguments()[0];

    }

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private Session getSession(){return sessionFactory.getCurrentSession();}

    @Transactional
    @Override
    public T create(T entity) {
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }

//    @Override
//    @Transactional(readOnly = true)
//    public T get(long id) {
//        return (T)getSession().get(entityClass, id);
//    }

    @Override
    @Transactional
    public void update(T t) {
        sessionFactory.getCurrentSession().update(t);
    }

    @Override
    @Transactional
    public void delete(T t) {
        sessionFactory.getCurrentSession().delete(t);
    }

}
