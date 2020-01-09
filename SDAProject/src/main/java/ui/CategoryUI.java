package ui;

import com.sda.supermarket.order.persistence.model.CategoryModel;

import java.util.List;
import java.util.Scanner;

import services.CategoryService;
import services.exception.CategoryNotFoundException;

/**
 * Class implementation for showing the output of different business operations related to categories on the screen, and for
 * receiving the input from the user.
 */
public class CategoryUI {

  private Scanner scanner = new Scanner(System.in);
  private CategoryService categoryService = new CategoryService();

  /**
   * Reads the category that will be added into the using the {@link CategoryService}
   */
  public void addCategory() {
    System.out.println("Introduceti codul categoriei:");
    String code = scanner.next();
    scanner.nextLine();
    System.out.println("Introduceti numele categoriei:");
    String name = scanner.nextLine();
    categoryService.addCategory(code, name);
  }

  /**
   * Prints the categories on the screen.The categories are retrieved using the {@link CategoryService}
   */
  public void printCategories() {
    printCategories(categoryService.getAllCategories());
  }

  /**
   * Reads a category.
   *
   * @return The category that was read.
   */
  public CategoryModel readCategory() {
    CategoryModel categoryFound = null;
    while (categoryFound == null) {
      String categoryCode = scanner.next();
      scanner.nextLine();
      try {
        categoryFound = categoryService.getCategoryById(categoryCode);
      } catch (CategoryNotFoundException e) {
        System.out.println("Please choose the code of the categories bellow!");
        printCategories(categoryService.getAllCategories());
      }
    }
    return categoryFound;
  }


  /**
   * Prints the categories on the screen.
   *
   * @param categories The categories that are printed on the screen.
   */
  private void printCategories(List<CategoryModel> categories) {
    if (categories == null || categories.isEmpty()) {
      System.out.println("No categories found in the system!");
      return;
    }
    categories.forEach(category -> {
      printCategory(category);
      System.out.println();
    });
  }

  /**
   * Prints a given category on the screen.
   *
   * @param category The category that will be printed on the screen.
   */
  private void printCategory(CategoryModel category) {
    System.out.print(category.getId() + " " + category.getName());
  }

}
