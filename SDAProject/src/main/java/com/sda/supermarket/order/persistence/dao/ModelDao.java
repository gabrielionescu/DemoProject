package com.sda.supermarket.order.persistence.dao;

import java.util.List;
import java.util.Optional;

import com.sda.supermarket.order.persistence.model.Model;

/**
 * Abstract class implementation for a (DAO) data access object, that contains a generic implementation for every
 * CRUD(Create/Read/Update/Delete)
 * on the data source(in this case the data source is a file.)
 */
public abstract class ModelDao<T extends Model> implements Dao<T> {

  /**
   * The file path of the file that will serve as a data source.
   */
  private String fileName;

  /**
   * Generic object reader, that can read/write any type of object into a file
   */
  private ObjectFileScanner<T> genericFileReader = new ObjectFileScanner<T>();

  public ModelDao(String fileName) {
    this.fileName = fileName;

  }

  @Override
  public List<T> getAll() {
    return genericFileReader.readFromFile(fileName);
  }

  @Override
  public Optional<T> findById(String id) {
    List<T> models = getAll();
    return findInList(models, id);
  }


  private Optional<T> findInList(List<T> models, String id) {
    if (models.isEmpty()) {
      return Optional.empty();
    }
    for (T model : models) {
      if (model.getId().equals(id)) {
        return Optional.of(model);
      }
    }
    return Optional.empty();
  }

  @Override
  public void remove(String id) {
    List<T> models = getAll();
    Optional<T> modelFound = findInList(models, id);
    if (modelFound.isPresent()) {
      Model modelToBeRemoved = modelFound.get();
      models.remove(modelToBeRemoved);
      genericFileReader.writeToFile(fileName, models);
    }
  }

  @Override
  public void add(T objectToBeAdded) {
    List<T> models = getAll();
    models.add(objectToBeAdded);
    genericFileReader.writeToFile(fileName, models);
  }

  /**
   * Sets the file path the will serve as a data source.
   * @param fileName The file name.
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }
}
