package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {

    @Test
    public void feedMoney() {
    }

    @Test
    public void getChange() {
    }

    @Test
    public void selectProduct() {
        VendingMachine vendingMachine = new VendingMachine();
        Inventory inventory = vendingMachine.getInventory();
        inventory.loadInventory();

        Assert.assertEquals(16, inventory.getInventory().size());
        Product product = vendingMachine.selectProduct("A1");
        Assert.assertEquals("Potato Crisps", product.getName());
    }
}