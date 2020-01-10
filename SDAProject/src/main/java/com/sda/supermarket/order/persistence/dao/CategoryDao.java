package com.sda.supermarket.order.persistence.dao;

import com.sda.supermarket.order.persistence.model.CategoryModel;

/**
 * Class implementation for providing CRUD(Create Read Update Delete) on categories ( {@link CategoryModel} ).
 */
public class CategoryDao extends ModelDao<CategoryModel> {


  private static final String DEFAULT_CATEGORY_FILE = "categories.txt";

  /**
   * Constructor , sets the file path for the category file
   */
  public CategoryDao() {
    super(DEFAULT_CATEGORY_FILE);
  }
}
