package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.VendingMachine;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION};
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	//VendingMachine vendingMachine = new VendingMachine("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-orange-team-3\\src\\main\\resources\\Log.txt");

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}



	public void run() {
		VendingMachine vendingMachine = new VendingMachine("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-orange-team-3\\src\\main\\resources\\Log.txt");
		vendingMachine.machineStartUp();
		Scanner sc = new Scanner(System.in);
		while (true) {

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				String[] newArray = vendingMachine.printInventory();
				int index = 0;
				for (String text : newArray) {
					System.out.println(newArray[index]);
					index++;
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while(true){
				System.out.println("Current Money Provided: $" + vendingMachine.getBalance());
				choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					if (choice.equals(PURCHASE_MENU_FEED_MONEY)) {
						System.out.println("Please enter the money you wish to feed(whole dollars only):");
						String userInput = sc.nextLine();
						int userInteger = Integer.valueOf(userInput);
						vendingMachine.addToBalance(userInteger);

					} else if (choice.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
						String[] newArray = vendingMachine.printInventory();
						int index = 0;
						for (String text : newArray) {
							System.out.println(newArray[index]);
							index++;
						}
						System.out.println("Please enter a slot number:");
						String userInput = sc.nextLine();
						//vendingMachine.dispenseItem(userInput);
						vendingMachine.dispenseItem(userInput);
					} else if (choice.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
						vendingMachine.giveChange();
						break;
					}
				}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("See you next time!");
				break;
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

}
