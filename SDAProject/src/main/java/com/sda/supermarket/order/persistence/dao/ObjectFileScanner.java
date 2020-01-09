package com.sda.supermarket.order.persistence.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class implementation for reading and writing objects into a file.
 * @param <T>
 */
public class ObjectFileScanner<T> {

  /**
   * Writes a list of objects into a file.
   * @param fileName The file name.
   * @param objectToBeWriteInFile The list of generic objects that will be written into the files.
   */
  public void writeToFile(String fileName, List<T> objectToBeWriteInFile) {
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(fileName);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

      // Write objects to file
      objectOutputStream.writeObject(objectToBeWriteInFile);
      objectOutputStream.close();
      fileOutputStream.close();
    } catch (Exception exception) {
      throw new RuntimeException("An error has apear while initialize the file");
    }
  }

  /**
   * Reads the list of generic object from a file located at the given file path.
   * @param fileName The file path of the file.
   * @return The list of generic objects that was read from the given file.
   */
  public List<T> readFromFile(String fileName) {
    File file = new File(fileName);
    try {
      if(!file.exists()){
        file.createNewFile();
        return new ArrayList<T>();
      }
      if(file.length() == 0){
        return new ArrayList<T>();
      }
      FileInputStream fileInputStream = new FileInputStream(file);
      ObjectInputStream outputInputStream = new ObjectInputStream(fileInputStream);
      // Read objects
      List<T> objectToRead = (List<T>) outputInputStream.readObject();
      return objectToRead;
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
      throw new RuntimeException();
    } catch (IOException e) {
      System.out.println("Error initializing stream");
      throw new RuntimeException();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException("An error has apear while initialize the file");
    }
  }
}
