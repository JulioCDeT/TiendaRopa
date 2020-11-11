package io.juliocdet.tiendaderopa.repository;

public interface Dao {
    boolean create(Object newItem);
    boolean update(Object item, Object newValue);
    Object read(Object item);
    boolean delete(Object item);
}
