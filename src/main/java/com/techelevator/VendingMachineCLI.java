package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit To Main Menu";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE};

	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_DEPOSIT_MONEY = "Deposit Money";
	private static final String PURCHASE_MENU_OPTION_END_TRANSACTION = "End Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT,
			 PURCHASE_MENU_OPTION_DEPOSIT_MONEY, PURCHASE_MENU_OPTION_END_TRANSACTION };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		VendingMachine vm = new VendingMachine(new File("vendingmachine.csv"));

		String[] activeMenu = MAIN_MENU_OPTIONS;

		boolean run = true;

		while (run) {
			String choice = (String) menu.getChoiceFromOptions(activeMenu);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				vm.getInventory();
				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				activeMenu = PURCHASE_MENU_OPTIONS;
				// do purchase
			} else if (userChoice.equals(MAIN_MENU_OPTION_EXIT)) {
				vm.exitDialog();
				run = false;
			} else if (userChoice.equals(PURCHASE_MENU_OPTION_DEPOSIT_MONEY)) {
				String deposit = (String) menu.getChoiceFromOptions(vm.currentInventory.keySet().toArray(), true);
				vm.makeDeposit(deposit);
			} else if (userChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
				vm.listItems();
				String product = (String) menu.getChoiceFromOptions(vm.currentInventory.keySet().toArray(), true);
				vm.dispense(product);
			} else if (userChoice.equals(PURCHASE_MENU_OPTION_END_TRANSACTION)) {
				vm.closeBank();
				activeMenu = MAIN_MENU_OPTIONS;
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
