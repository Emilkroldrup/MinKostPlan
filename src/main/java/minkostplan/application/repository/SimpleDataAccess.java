package minkostplan.application.repository;

import java.util.List;

public interface SimpleDataAccess<T> {
    T findByProperty(String property, Object value);
    List<T> findAll();
}
