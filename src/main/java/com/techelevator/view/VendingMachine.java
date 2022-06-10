package com.techelevator.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    //Attributes
    private BigDecimal balance = new BigDecimal("0.00");
    private List<VendingMachineItem> stock = new ArrayList<>();
    private List<Slot> slots = new ArrayList<>();
    //private String inputFile;
    //private String outputFile;
   // private float feedMoney;
    //private String selectedProductId;

    //Constructors
    //public VendingMachine ()
      //feedMoney =0;
     // readInputFile();
    //Getters
    public BigDecimal getBalance() {
        return balance;
    }
    public List<VendingMachineItem> getStock() {
        return stock;
    }
    public List<Slot> getSlots() {
        return slots;
    }

    //Setters
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    //Methods
    //read vendingmachine.csv
    public void machineStartUp() {
        String path = "C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-orange-team-3\\vendingmachine.csv";
        File inventoryFile = new File(path);
        //List<VendingMachineItem> items = stock; // all items; we need five of each in corresponding slots
        try (Scanner fileReader = new Scanner(inventoryFile)) {
            while (fileReader.hasNextLine()) {
                String currentLine = fileReader.nextLine();
                String[] itemInfo = new String[4];
                itemInfo = currentLine.split("\\|");
                if (itemInfo[3].equals("Chip")) {
                    Chips newChips = new Chips(itemInfo[1], itemInfo[0], new BigDecimal(itemInfo[2]));
                    stock.add(newChips);
                }
                if (itemInfo[3].equals("Candy")) {
                    Candy newCandys = new Candy(itemInfo[1], itemInfo[0], new BigDecimal(itemInfo[2]));
                    stock.add(newCandys);
                }
                if (itemInfo[3].equals("Gum")) {
                    Gum newGums = new Gum(itemInfo[1], itemInfo[0], new BigDecimal(itemInfo[2]));
                    stock.add(newGums);
                }
                if (itemInfo[3].equals("Drink")) {
                    Drink newDrinks = new Drink(itemInfo[1], itemInfo[0], new BigDecimal(itemInfo[2]));
                    stock.add(newDrinks);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Stoking method: Create new instances of slots, fill them with the items from the stock list, and add those full slots to the slots list
        for (VendingMachineItem item : stock) {
            Slot newSlot = new Slot(item.getSlotNumber(), item.getName(), item.getPrice(), 5);
            slots.add(newSlot);
        }

    }


    //Override toString method so that toString() generates a String that will display Slot number of item, name of item,
    //quantity of item, and price of item for each item in the stock list
    public String[] printInventory() {
        //return "MOVIE - " + getTitle() + " - " + getFormat() + " $" + getRentalPrice();
        //all items in the vending machine with its quantity remaining
        String[] inventory = new String[slots.size()];
        int index = 0;
        for (Slot slot : slots) {
            if (slot.getCurrentNumberOfItems() > 0) {
                inventory[index] = slot.getSlotNumber() + " | " + slot.getItemInResidence() + " | " + slot.getCurrentNumberOfItems();
                index++;
            } else {
                inventory[index] = slot.getSlotNumber() + " | " + slot.getItemInResidence() + " | SOLD OUT";
                index++;
            }
        }
        return inventory;

    }

    //Dispenses items from slots when purchased
    public String dispenseItem(String slotNumber) {
        String messageDisplayed = "";
        for (Slot slot : slots) {
            if (slotNumber.equals(slot.getSlotNumber()) && slot.getCurrentNumberOfItems() > 0) {
                // item name, cost, and the money remaining. Dispensing also returns a message
                messageDisplayed = slot.getItemInResidence() + " | $" + slot.getItemInResidencePrice() + " | $" +
                        (balance.subtract(slot.getItemInResidencePrice())) + " | Placeholder message!";
            } else if (slotNumber.equals(slot.getSlotNumber()) && slot.getCurrentNumberOfItems() <= 0) {
                messageDisplayed = "The item you've selected is currently sold out.  Please choose another option.";
            } else if (!slotNumber.equals(slot.getSlotNumber())) {
                messageDisplayed = "The item code you entered does not exits.  Please try again.";
            }
        }


        return messageDisplayed;
    }






        //Return change and set balance to 0.00

    //write to Log.txt every time money is fed into the machine or a purchase is made
    //If Log.txt doesn't exist, create the file and write to it
    //Else Append Log.txt

    }

