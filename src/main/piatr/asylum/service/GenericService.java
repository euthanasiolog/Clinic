package asylum.service;

import asylum.abstractClasses.BaseEntity;

/**
 * Created by piatr on 26.05.17.
 */
public interface GenericService<T extends BaseEntity> {
    T create(T t);
    T get(long id);
    void update(T t);
    void delete(T t);
}
