package java.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.abstractClasses.BaseEntity;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by piatr on 23.05.17.
 */
@Repository
@Transactional
public abstract class DAO_CRUD_impl<T extends BaseEntity> implements DAO_CRUD<T>{

    private final Class<T> entityClass;

    public DAO_CRUD_impl() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        entityClass = (Class) parameterizedType.getActualTypeArguments()[0];
    }

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private Session getSession(){return sessionFactory.getCurrentSession();}

    @Override
    public T create(T entity) {
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }

    @Override
    @Transactional(readOnly = true)
    public T get(long id) {
        return (T)getSession().get(entityClass, id);
    }

    @Override
    public void update(T t) {
        sessionFactory.getCurrentSession().update(t);
    }

    @Override
    public void delete(T t) {
        sessionFactory.getCurrentSession().delete(t);
    }
}
