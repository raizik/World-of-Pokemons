package com.plainid.assignment.dao;

import java.util.List;
public interface Dao<T, R, K, L> {

    T get(K id);

    List<T> getAll();

    void save(T t);

    void update(T t, R param1, L param2);

    void delete(T t);

}
