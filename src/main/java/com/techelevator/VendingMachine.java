package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class VendingMachine {

   private int customerBalance = 0;
   private int machineBalance = 0;
   private Inventory inventory = new Inventory();

    public Inventory getInventory() {
        return inventory;
    }

    public int feedMoney (int dollars) {
// TODO: write tests
        customerBalance += dollars * 100;
        return customerBalance;

    }
    public int getChange() {
        // TODO: write tests
        int moneyToReturn = customerBalance;
        customerBalance = 0;
        return moneyToReturn;
    }

    public Product selectProduct(String location) throws SelectProductException {
        if (!inventory.getInventory().containsKey(location)) {
            // key does not exist
            throw new SelectProductException(" Does not exist");
        }
        TreeMap<String, Product> map = inventory.getInventory();
        Product product = map.get(location);
        if(product.getInventory() == 0) {
            //sold out
            throw new SelectProductException("Product sold out");
        }
        if (customerBalance < product.getPrice()) {
            // not enough money
            throw new SelectProductException("You do not have enough money");
        }
        customerBalance -= product.getPrice();
        product.reduceInventory();
       return product;
    }






// check to see if location is valid (if product is null not in map)
    // check to see if sold out (product.getcount < 1 )
    // check to see if enough $$(customer balance is >= item.getprice)
    // deduct cost of product from customer balance
    // reduce the product.count by 1 (maybe setter or another method on product class to reduce count (--count)






}
