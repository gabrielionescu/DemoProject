package com.sda.supermarket.order.persistence.dao;

import com.sda.supermarket.order.persistence.model.Model;

import java.util.List;
import java.util.Optional;

/**
 * Generic interface for providing CRUD(Create, Read, Update, Delete) operations on a data source.
 */
public interface Dao<T extends Model> {

  /**
   * Reads all generic entities from the data source.
   *
   * @return list of objects that were read from the data source.
   */
  List<T> getAll();

  /**
   * Finds an object by id, from the data source.
   *
   * @param id The id of the object that will be found.
   * @return A optional objecting containing the object that was found.
   */
  Optional<T> findById(String id);

  /**
   * Removes an Object that has the given id from the data source.
   *
   * @param id The id of the object that will be removed.
   */
  void remove(String id);

  /**
   * Adds the object into the data source.
   *
   * @param objectToBeAdded The object that will be added in the data source.
   */
  void add(T objectToBeAdded);

}
