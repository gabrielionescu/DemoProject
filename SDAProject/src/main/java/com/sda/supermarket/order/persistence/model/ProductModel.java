package com.sda.supermarket.order.persistence.model;

/**
 * Class implementation for a product that will be written into a data source.
 */
public class ProductModel extends Model{

  private String name;

  private String image;

  private double price;

  private CategoryModel category;

  private String currency;

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public CategoryModel getCategory() {
    return category;
  }

  public void setCategory(CategoryModel category) {
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }
}
