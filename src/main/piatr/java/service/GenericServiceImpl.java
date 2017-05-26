package java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.abstractClasses.BaseEntity;
import java.dao.GenericDAO;

/**
 * Created by piatr on 26.05.17.
 */
@Service
public class GenericServiceImpl<T extends BaseEntity> implements GenericService<T> {

    @Autowired
    private GenericDAO<T> genericDAO;

    @Override
    public T create(T t) {
        return genericDAO.create(t);
    }

    @Override
    public T get(long id) {
        return genericDAO.get(id);
    }

    @Override
    public void update(T t) {
        genericDAO.update(t);
    }

    @Override
    public void delete(T t) {
        genericDAO.delete(t);
    }
}
