package dao;

/**
 * Created by piatr on 23.05.17.
 */
public interface DAO_CRUD<T> {
    T create(T t);
    T update(T t);
    void update();
    void delete();
}
