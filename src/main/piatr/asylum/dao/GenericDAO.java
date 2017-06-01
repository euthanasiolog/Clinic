package asylum.dao;

import asylum.abstractClasses.BaseEntity;

/**
 * Created by piatr on 23.05.17.
 */
public interface GenericDAO<T extends BaseEntity> {
    T create(T t);
    T get(long id);
    void update(T t);
    void delete(T t);
}
