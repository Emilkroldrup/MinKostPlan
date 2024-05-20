package minkostplan.application.DBcontroller;

import java.util.List;

/**
 * Simple data access interface for CRUD operations.
 *
 * @param <T> the type of the entity
 */
public interface SimpleDataAccess<T> {

    /**
     * Finds a value of a entity by a specific property.
     *
     * @param property the property name
     * @param value the value of the property
     * @return the found value
     */
    T findByProperty(String property, Object value);
    
    /**
     * 
     * return everything in a whole entity.
     *
     * @return a list of all the values in the entity
     */
    List<T> findAll();
}
