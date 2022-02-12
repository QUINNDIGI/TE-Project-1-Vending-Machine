package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String PURCHASE_MENU_OPTIONS = "Menu Options";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE};

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
//		VendingMachine vm = new VendingMachine(new File("vendingmachine.csv"));
//
//		String[] activeMenu = MAIN_MENU_OPTIONS;
//
//		boolean run = true;
//
//		while (true) {
//			String choice = (String) menu.getChoiceFromOptions(activeMenu);
//
//			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
//				vm.getInventory();
//				// display vending machine items
//			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
//				activeMenu = PURCHASE_MENU_OPTIONS;
//				// do purchase
//			}
//		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
