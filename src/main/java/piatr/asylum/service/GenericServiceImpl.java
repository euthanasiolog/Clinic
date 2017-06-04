package piatr.asylum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.abstractClasses.BaseEntity;
import piatr.asylum.dao.GenericDAO;
import piatr.asylum.abstractClasses.BaseEntity;
import piatr.asylum.dao.GenericDAO;

/**
 * Created by piatr on 26.05.17.
 */
@Service("genericService")
@Transactional
public  class GenericServiceImpl<T extends BaseEntity> implements GenericService<T> {

    @Autowired
    private GenericDAO<T> genericDAO;

    @Override
    @Transactional
    public T create(T t) {
        return genericDAO.create(t);
    }

//    @Override
//    public T get(long id) {
//        return genericDAO.get(id);
//    }

    @Override
    @Transactional
    public void update(T t) {
        genericDAO.update(t);
    }

    @Override
    @Transactional
    public void delete(T t) {
        genericDAO.delete(t);
    }

    public GenericServiceImpl() {
    }
}
