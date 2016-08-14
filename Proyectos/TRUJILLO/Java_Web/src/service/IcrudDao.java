package service;

import java.util.List;

public interface IcrudDao<T> {

    // definir las firmas
    void create(T t) throws Exception;

    void update(T t) throws Exception;

    void delete(T t) throws Exception;

    T find(Object t) throws Exception;

    List<T> readAll() throws Exception;
}
