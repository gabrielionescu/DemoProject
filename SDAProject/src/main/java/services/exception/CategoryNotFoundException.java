package services.exception;

/**
 * Class implementation for an exception that will be thrown when a category is not found.
 */
public class CategoryNotFoundException extends Exception{

  public CategoryNotFoundException(){
    super("Category Not Found!");
  }
}
