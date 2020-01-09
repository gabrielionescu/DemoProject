package com.sda.supermarket.order.persistence.model;

/**
 * Class implementation for a category that will be written into a data source.
 * Ex (1, Apa)
 */
public class CategoryModel extends Model {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
