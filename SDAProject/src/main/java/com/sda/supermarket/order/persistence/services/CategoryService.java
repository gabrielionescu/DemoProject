package com.sda.supermarket.order.persistence.services;

import com.sda.supermarket.order.persistence.dao.CategoryDao;
import com.sda.supermarket.order.persistence.model.CategoryModel;
import com.sda.supermarket.order.persistence.services.exception.CategoryNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * Class implementation for all the business operations related to categories.
 */
public class CategoryService {

  /**
   * Category data access object, is used in order to execute CRUD(CREATE/READ/UPDATE/DELETE) operations on categories.
   */
  private CategoryDao categoryDao = new CategoryDao();

  /**
   * Gets all the categories.
   *
   * @return list of categories.
   */
  public List<CategoryModel> getAllCategories() {
    List<CategoryModel> categories = categoryDao.getAll();
    return categories;
  }

  /**
   * Creates and adds a category in the data source using the {@link CategoryDao}.
   *
   * @param code The code of the category.
   * @param name The name of the category.
   */
  public void addCategory(String code, String name) {
    CategoryModel categoryModel = new CategoryModel();
    categoryModel.setId(code);
    categoryModel.setName(name);
    categoryDao.add(categoryModel);
  }

  /**
   * Gets the category by the given code.
   *
   * @param code The code of the category that will be found.
   * @return The category that was found based on the given code.
   * @throws CategoryNotFoundException This exception is thrown if the given category is not found.
   */
  public CategoryModel getCategoryById(String code) throws CategoryNotFoundException {
    Optional<CategoryModel> categoryModelOptional = categoryDao.findById(code);
    if (categoryModelOptional.isPresent()) {
      return categoryModelOptional.get();
    } else {
      throw new CategoryNotFoundException();
    }
  }

}
