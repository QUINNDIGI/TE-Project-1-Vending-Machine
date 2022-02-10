package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Inventory {

    private TreeMap <String, Product> inventory = new TreeMap<>();
    File vendingMachineInventory = new File("vendingmachine.csv");
    public void loadInventory() {
  try (Scanner fileScanner = new Scanner(vendingMachineInventory)) {
      while (fileScanner.hasNextLine()) {
          String line = fileScanner.nextLine();
          String[] inventoryArr = fileScanner.nextLine().split("|", 4);
          String location = inventoryArr[0];
          String productName = inventoryArr[1];
          Double productPrice = Double.valueOf(inventoryArr[2]);
          Integer intPrice = (int) (productPrice * 100);
          String productCategory = inventoryArr[3];
          Product product = null;
          if (productCategory.equalsIgnoreCase("Chip")) {
              product = new Chips(productName, intPrice);

          } else if (productCategory.equalsIgnoreCase("Gum")) {
              product = new Gum(productName, intPrice);

          } else if (productCategory.equalsIgnoreCase("Drink")) {
              product = new Drink(productName, intPrice );

          } else if (productCategory.equalsIgnoreCase("Candy")) {
              product = new Candy(productName, intPrice );

          }

          inventory.put(location, product);
      }
      } catch (FileNotFoundException e) {
      e.printStackTrace();
  }
    }



    public Inventory() throws FileNotFoundException {
    }
}
