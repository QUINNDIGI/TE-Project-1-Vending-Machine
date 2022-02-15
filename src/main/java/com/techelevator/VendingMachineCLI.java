package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_END_TRANSACTION = "End Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT,
		 PURCHASE_MENU_OPTION_END_TRANSACTION };

	private Menu menu;

	private Scanner in = new Scanner(System.in);

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	//Everything below this is from Rich
	public void run() {
		VendingMachine vm = new VendingMachine();
		Inventory inventory = vm.getInventory();
		inventory.loadInventory();

		String[] activeMenu = MAIN_MENU_OPTIONS;

		boolean run = true;

		while (run) {
			String choice = (String) menu.getChoiceFromOptions(activeMenu);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayItems(inventory);
				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				activeMenu = PURCHASE_MENU_OPTIONS;
				// do purchase
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Have A Vendo-Matic Day!");
				run = false;
			} else if (choice.equals(PURCHASE_MENU_FEED_MONEY)) {
				System.out.print("Enter Money In Whole Dollar Amounts [$1, $2, $5, or $10 ONLY]: ");
				String money = in.nextLine();
				try {
					vm.feedMoney(Integer.parseInt(money));
					System.out.println("Your Current Balance Is: $" + vm.getCustomerBalance() / 100.0);

				} catch (FileNotFoundException | SelectProductException e) {
					System.out.println("Failed To Feed Money: " + e.getMessage());
				}
			} else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
				displayItems(inventory);
				System.out.print("Enter Product Code: ");
				String slotIdentifier = in.nextLine();
				try {
					Product product = vm.selectProduct(slotIdentifier);
					System.out.println("Thank You For Your Purchase Of " + product.getName() + "! " + product.getSound());
					System.out.println("Your Current Balance Is: $" + vm.getCustomerBalance() / 100.0);
				} catch (Exception e) {
					System.out.println("Failed To Select Product: " + e.getMessage());
				}


			} else if (choice.equals(PURCHASE_MENU_OPTION_END_TRANSACTION)) {
				try {
					int change = vm.getChange();
					System.out.println("Your Change Is: $" + change / 100.0);
				} catch (FileNotFoundException e) {
					System.out.println("Failed To Get Change" + e.getMessage());
				}

				activeMenu = MAIN_MENU_OPTIONS;
			}
		}
	}

	private void displayItems(Inventory inventory) {
		Map<String, Product> productMap = inventory.getInventory();
		for (Map.Entry<String, Product> entry : productMap.entrySet()) {
			Product value = entry.getValue();
			System.out.println(entry.getKey() + " " + value.getName() + " " + value.getPrice() + " " + value.getInventory());
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
