package com.sda.supermarket.order.persistence.ui;

import com.sda.supermarket.order.persistence.model.CategoryModel;
import com.sda.supermarket.order.persistence.model.ProductModel;
import com.sda.supermarket.order.persistence.services.ProductService;

import java.util.List;
import java.util.Scanner;

/**
 * Class implementation for showing the output of different business operations related to products on the screen, and
 * for
 * receiving the input from the user.
 */
public class ProductUI {

  private Scanner scanner = new Scanner(System.in);
  private ProductService productService = new ProductService();
  private CategoryUI categoryUI = new CategoryUI();


  /**
   * Prints the products on the screen.
   */
  public void printProducts() {
    printProducts(productService.listProducts());
  }

  /**
   * Prints the given list of products on the screen.
   *
   * @param products The list of products that will be printed on the screen.
   */
  private void printProducts(List<ProductModel> products) {
    if (products == null || products.isEmpty()) {
      System.out.println("No products found in the system!");
      return;
    }
    products.forEach(productModel -> {
      printProduct(productModel);
      System.out.println();
    });
  }

  /**
   * Prints the given products on the screen.
   *
   * @param product The product that will be printed on the screen.
   */
  private void printProduct(ProductModel product) {
    System.out.print(product.getId() + " " + product.getName() + " ("
                     + product.getCategory().getName() + ") " +
                     product.getPrice() + " " + product.getCurrency());
  }

  /**
   * Reads the product that will be added into the using the {@link ProductService}
   */
  public void addProduct() {
    ProductModel newProduct = readNewProduct();
    productService.addProduct(newProduct);
    System.out.print("Produsul ");
    printProduct(newProduct);
    System.out.println(" a fost adaugat.");
  }
  /**
   * Reads a product.
   *
   * @return The product that was read.
   */
  private ProductModel readNewProduct() {
    ProductModel productModel = new ProductModel();
    System.out.println("Introduceti codul produsului:");
    String code = scanner.next();
    productModel.setId(code);
    scanner.nextLine();
    System.out.println("Introduceti numele produsului:");
    String nume = scanner.nextLine();
    productModel.setName(nume);
    System.out.println("Alegeti codul uneia dintre urmatoarele categorii:");
    categoryUI.printCategories();
    CategoryModel categoryModel = categoryUI.readCategory();
    productModel.setCategory(categoryModel);
    System.out.println("Introduceti pretul produsului");
    double price = scanner.nextDouble();
    productModel.setPrice(price);
    System.out.println("Introduceti moneda produsului");
    String currency = scanner.nextLine();
    productModel.setCurrency(currency);
    return productModel;
  }

}
