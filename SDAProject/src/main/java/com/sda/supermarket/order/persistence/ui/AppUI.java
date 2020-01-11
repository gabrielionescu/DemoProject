package com.sda.supermarket.order.persistence.ui;

import java.util.Scanner;

/**
 * Class implementation for the main application object.
 */
public class AppUI {

  private Scanner scanner = new Scanner(System.in);
  private ProductUI productUI = new ProductUI();
  private CategoryUI categoryUI = new CategoryUI();


  /**
   * Stats the program.
   */
  public void startProgram() {
    int option = 0;
    while (option != 5) {
      printMenu();
      option = scanner.nextInt();
      if (option == 1) {
        productUI.printProducts();
      } else if (option == 2) {
        productUI.addProduct();
      } else if (option == 3) {
        categoryUI.printCategories();
      } else if (option == 4) {
        categoryUI.addCategory();
      }
    }
  }

  private void printMenu() {
    System.out.println("Bine ati venit la ProductCalculator");
    System.out.println("Alegeti optiunea:");
    System.out.println("1.Afisare produse");
    System.out.println("2.Adaugare produs");
    System.out.println("3.Afisare categorii");
    System.out.println("4.Adauga categorie");
    System.out.println("5.Exit");
  }


}
