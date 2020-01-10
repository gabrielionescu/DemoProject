package com.sda.supermarket.order.persistence.model;

import java.io.Serializable;

/**
 * Abstract class implementation of the root class of every model that will be written into the data source.
 * This class contains all common fields for all child classes.
 * This class is also mark as {@link Serializable} so that every child object can be read/write using a data source.
 */
public abstract class Model implements Serializable {

  private String id;

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
