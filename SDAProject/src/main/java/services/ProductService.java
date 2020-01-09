package services;

import com.sda.supermarket.order.persistence.dao.CategoryDao;
import com.sda.supermarket.order.persistence.dao.ProductDao;
import com.sda.supermarket.order.persistence.model.CategoryModel;
import com.sda.supermarket.order.persistence.model.ProductModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Class implementation for all the business operations related to products.
 */
public class ProductService {

  /**
   * Product data access object that is used to perform CRUD(Create/Read/Update/Delete) operations on products.
   */
  private ProductDao productDao = new ProductDao();

  /**
   * Category data access object that is used to perform CRUD(Create/Read/Update/Delete) operations on categories.
   */
  private CategoryDao categoryDao = new CategoryDao();

  /**
   * Adds a given product into the data source using {@link ProductDao}.
   *
   * @param product The product that will be added into the data source.
   */
  public void addProduct(ProductModel product) {
    productDao.add(product);
  }

  /**
   * Lists all the products from the data source using the @{@link ProductDao}
   *
   * @return The list of products that were found into the data source.
   */
  public List<ProductModel> listProducts() {
    return productDao.getAll();
  }

  /**
   * Lists products by the given category.
   *
   * @param code The code of the category that is used to retrieve products that only have the category with the given
   *             code.
   * @return The list of products that have the given category.
   */
  public List<ProductModel> listProductsByCategory(String code) {
    Optional<CategoryModel> categoryModelOptional = categoryDao.findById(code);
    if (categoryModelOptional.isPresent()) {
      CategoryModel categoryModel = categoryModelOptional.get();
      return productDao.getAll().stream().filter(productModel ->
                                                     productModel.getCategory().getId()
                                                         .equals(categoryModel.getId()))
          .collect(Collectors.toList());

    }
    return new ArrayList<>();
  }


}
