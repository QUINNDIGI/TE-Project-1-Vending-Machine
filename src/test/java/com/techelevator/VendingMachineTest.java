package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {

    @Test
    public void feedMoney() throws Exception {
        VendingMachine vendingMachine = new VendingMachine();
        int result = vendingMachine.feedMoney(5);
        Assert.assertEquals(500, result);
    }

    @Test
    public void getChange() throws Exception {
        VendingMachine vendingMachine = new VendingMachine();
        Inventory inventory = vendingMachine.getInventory();
        inventory.loadInventory();
        vendingMachine.feedMoney(10);
        int result = vendingMachine.getChange();
        Assert.assertEquals(1000, result);

        vendingMachine.feedMoney(10);
        Product product = vendingMachine.selectProduct("A1");
        result = vendingMachine.getChange();
        Assert.assertEquals(1000 - product.getPrice(),result);
    }

    @Test
    public void selectProduct() throws Exception {
        VendingMachine vendingMachine = new VendingMachine();
        Inventory inventory = vendingMachine.getInventory();
        inventory.loadInventory();
        vendingMachine.feedMoney(10);
        Assert.assertEquals(16, inventory.getInventory().size());

        Product product = vendingMachine.selectProduct("A1");
        Assert.assertEquals("Potato Crisps", product.getName());
    }
    @Test
    public void selectProduct_invalidKey() throws Exception  {
        VendingMachine vendingMachine = new VendingMachine();
        Inventory inventory = vendingMachine.getInventory();
        inventory.loadInventory();

        Assert.assertEquals(16, inventory.getInventory().size());
        Product product = null;
        try {
            product = vendingMachine.selectProduct("G7");
            fail("Expected select product exception");
        } catch (SelectProductException e) {
            // expected
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void selectProduct_SoldOut() throws Exception  {
        VendingMachine vendingMachine = new VendingMachine();
        Inventory inventory = vendingMachine.getInventory();
        inventory.loadInventory();
        vendingMachine.feedMoney(10);

        Assert.assertEquals(16, inventory.getInventory().size());
        try {
            vendingMachine.selectProduct("A1");
            vendingMachine.selectProduct("A1");
            vendingMachine.selectProduct("A1");
            vendingMachine.selectProduct("A1");
            vendingMachine.selectProduct("A1");
            vendingMachine.selectProduct("A1");



            fail("Expected select product exception");
        } catch (SelectProductException e) {
            // expected
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void selectProduct_NoMoney() throws Exception  {
        VendingMachine vendingMachine = new VendingMachine();
        Inventory inventory = vendingMachine.getInventory();
        inventory.loadInventory();
        vendingMachine.feedMoney(5);

        Assert.assertEquals(16, inventory.getInventory().size());
        try {
            vendingMachine.selectProduct("A1");
            vendingMachine.selectProduct("A1");


            fail("Expected select product exception");
        } catch (SelectProductException e) {
            // expected
            System.out.println(e.getMessage());
        }

    }



}