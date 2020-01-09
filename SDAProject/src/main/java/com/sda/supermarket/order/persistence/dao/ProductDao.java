package com.sda.supermarket.order.persistence.dao;

import com.sda.supermarket.order.persistence.model.CategoryModel;
import com.sda.supermarket.order.persistence.model.ProductModel;

/**
 * Class implementation for providing CRUD(Create Read Update Delete) on categories ( {@link ProductModel} ).
 */
public class ProductDao extends ModelDao<ProductModel> {

  public ProductDao() {
    super( "products.txt");
  }

}
