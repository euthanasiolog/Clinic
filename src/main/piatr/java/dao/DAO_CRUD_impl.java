package java.dao;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.abstractClasses.BaseEntity;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by piatr on 23.05.17.
 */
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

    @Override
    public T create(T entity) {
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public T get(long id) {
        return (T) sessionFactory.getCurrentSession().get(entityClass, id);
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
