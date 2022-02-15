package com.techelevator;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class VendingMachine {
    List<String> list = new ArrayList<String>();

   private int customerBalance = 0;
   private int machineBalance = 0;
   private Inventory inventory = new Inventory();



    public Inventory getInventory() {
        return inventory;
    }

    public int feedMoney (int dollars) throws FileNotFoundException, SelectProductException {

        customerBalance += dollars * 100;
        if ((dollars != 1) && (dollars != 2) && (dollars != 5) && (dollars != 10)) {
            customerBalance -= dollars * 100;
            throw new SelectProductException("Please Enter [$1, $2, $5, $10 ONLY]");



        } else {
            String logMessage = String.format("FEED MONEY: $%.2f $%.2f", (double) dollars, customerBalance / 100.0);
            logTransaction(logMessage);
            return customerBalance;
        }

    }

    public int getCustomerBalance() {
        return customerBalance;
    }

    public int getChange() throws FileNotFoundException {

        int moneyToReturn = customerBalance;
        customerBalance = 0;
        String logMessage = String.format("GIVE CHANGE: $%.2f $%.2f",  moneyToReturn/100.0, customerBalance/100.0);
        logTransaction(logMessage);
        return moneyToReturn;
    }

    public Product selectProduct(String location) throws SelectProductException, FileNotFoundException {
        if (!inventory.getInventory().containsKey(location)) {
            // key does not exist
            throw new SelectProductException(" Does not exist");
        }
        Map<String, Product> map = inventory.getInventory();
        Product product = map.get(location);
        if(product.getInventory() == 0) {
            //sold out
            throw new SelectProductException("Product sold out");
        }



        if (customerBalance < product.getPrice()) {
            // not enough money
            throw new SelectProductException("You do not have enough money");
        }
        double previousBalance = customerBalance / 100.0;
        customerBalance -= product.getPrice();
        product.reduceInventory();

        String logMessage = String.format("%s %s %.2f %.2f", product.getName(), location, previousBalance, customerBalance / 100.0);
        logTransaction(logMessage);

       return product;
    }

    public List<String> getList(){
        return this.list;
    }



    public void logTransaction(String message) throws FileNotFoundException {
        File purchaseRecord = new File("src/test/resources/Log.txt");

        try(PrintWriter logWriter = new PrintWriter(new FileOutputStream(purchaseRecord, true))){

            LocalDateTime dateTime = LocalDateTime.now(); //Gets the current date and time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");
            String logString = dateTime.format(formatter) + " " + message + System.lineSeparator();

            logWriter.append(logString);

        }

      }
}








