package com.techelevator;

public class Bank {

    private int machineBalance;
    private int customerBalance;

    public Bank(int machineBalance, int customerBalance) {
        this.machineBalance = machineBalance;
        this.customerBalance = customerBalance;
    }

    public int getMachineBalance() {
        return machineBalance;
    }

    public int getCustomerBalance() {
        return customerBalance;
    }

    public int addToVendingMachineBalance() {
        machineBalance += customerBalance;
        return machineBalance;
    }

    Inventory inventory = new Inventory();

    //We want to subtract product price from the machine's balance to get how much money the customer gets back
    public int giveChange() {
        machineBalance -= Inventory.


}
