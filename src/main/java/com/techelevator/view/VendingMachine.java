package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    //Attributes
    private BigDecimal balance = new BigDecimal("0.00");
    private List<VendingMachineItem> stock = new ArrayList<>();
    private List<Slot> slots = new ArrayList<>();



    //Constructors
    //public VendingMachine ()

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
                VendingMachineItem newItem = new VendingMachineItem(itemInfo[1], itemInfo[3], itemInfo[0], new BigDecimal(itemInfo[2]));
                stock.add(newItem);
//                if (itemInfo[3].equals("Chip")) {
//                    Chips newChips = new VendingMachineItem(itemInfo[1], itemInfo[0], new BigDecimal(itemInfo[2]));
//                    stock.add(newChips);
//                }
//                if (itemInfo[3].equals("Candy")) {
//                    Candy newCandys = new Candy(itemInfo[1], itemInfo[0], new BigDecimal(itemInfo[2]));
//                    stock.add(newCandys);
//                }
//                if (itemInfo[3].equals("Gum")) {
//                    Gum newGums = new Gum(itemInfo[1], itemInfo[0], new BigDecimal(itemInfo[2]));
//                    stock.add(newGums);
//                }
//                if (itemInfo[3].equals("Drink")) {
//                    Drink newDrinks = new Drink(itemInfo[1], itemInfo[0], new BigDecimal(itemInfo[2]));
//                    stock.add(newDrinks);
//                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Stoking method: Create new instances of slots, fill them with the items from the stock list, and add those full slots to the slots list
        for (VendingMachineItem item : stock) {
            Slot newSlot = new Slot(item.getSlotNumber(), item, 5);
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
                inventory[index] = slot.getSlotNumber() + " | " + slot.getItem().getName() + " | " + slot.getCurrentNumberOfItems();
                index++;
            } else {
                inventory[index] = slot.getSlotNumber() + " | " + slot.getItem().getName() + " | SOLD OUT";
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
                if (slot.getItem().getType().equals("Chip")) {
                    messageDisplayed = slot.getItem().getName() + " | $" + slot.getItem().getPrice() + " | $" +
                            (balance.subtract(slot.getItem().getPrice())) + " | Crunch, Crunch, Yum!";
                    balance = balance.subtract(slot.getItem().getPrice());
                } else if (slot.getItem().getType().equals("Candy")) {
                    messageDisplayed = slot.getItem().getName() + " | $" + slot.getItem().getPrice() + " | $" +
                            (balance.subtract(slot.getItem().getPrice())) + " | Munch, Munch, Mmm-Good!";
                    balance = balance.subtract(slot.getItem().getPrice());
                } else if (slot.getItem().getType().equals("Drink")) {
                    messageDisplayed = slot.getItem().getName() + " | $" + slot.getItem().getPrice() + " | $" +
                            (balance.subtract(slot.getItem().getPrice())) + " | Cheers, Glug, Glug!";
                    balance = balance.subtract(slot.getItem().getPrice());
                } else if (slot.getItem().getType().equals("Gum")) {
                    messageDisplayed = slot.getItem().getName() + " | $" + slot.getItem().getPrice() + " | $" +
                            (balance.subtract(slot.getItem().getPrice())) + " | Chew, Chew, Pop!";
                    balance = balance.subtract(slot.getItem().getPrice());
                }

            } else if (slotNumber.equals(slot.getSlotNumber()) && slot.getCurrentNumberOfItems() <= 0) {
                messageDisplayed = "The item you've selected is currently sold out.  Please choose another option.";
            } else if (!slotNumber.equals(slot.getSlotNumber())) {
                messageDisplayed = "The item code you entered does not exits.  Please try again.";
            }
        }


        return messageDisplayed;
    }

    //Return change and set balance to 0.00
    public void giveChange() {
        double change = balance.doubleValue();
//        BigDecimal quarter = new BigDecimal("0.25");
//        BigDecimal dime = new BigDecimal("0.10");
//        BigDecimal nickle = new BigDecimal("0.5");
//
//
//        change = change.divide(quarter);

        double quarterValue = 0.25;
        double dimeValue = 0.10;
        double nickleValue = 0.03;

        int quarterCount = 0;
        int dimeCount = 0;
        int nickelCount = 0;

        quarterCount = (int)(change / quarterValue);
        change = change - (quarterValue * quarterCount);

        dimeCount = (int)(change / dimeValue);
        change = change - (dimeValue * dimeCount);

        nickelCount = (int)(change / nickleValue);
        change = change - (nickleValue * nickelCount);




        System.out.println("Here's your change! $" + balance + ": " + quarterCount + " Quarters, " + dimeCount + " Dimes, " + nickelCount + " Nickles.");
        balance = new BigDecimal("0.00");
    }

    //write to Log.txt every time money is fed into the machine or a purchase is made
    //If Log.txt doesn't exist, create the file and write to it
    //Else Append Log.txt
    public void logTransactions(BigDecimal moneyAmount, String transactionType) {
        String logPath = "Log.txt";
        File log = new File(logPath);
        Date todaysDate = new Date();
        String logLine = "";

        if (transactionType.equals("feed money")) {
            logLine = todaysDate + " FEED MONEY " + moneyAmount + " " + balance;
        } else if (transactionType.equals("dispense product")) {
            logLine = todaysDate + " product slot " + moneyAmount + " " + balance;
        } else if (transactionType.equals("give change")) {
            logLine = todaysDate + " GIVE CHANGE " + moneyAmount + " " + balance;
        }

        try (PrintWriter writer = new PrintWriter(log)) {
            if (!log.exists()) {
                log.createNewFile();
                writer.println(logLine);
            }






        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }







    //Feed money
    public BigDecimal addToBalance(BigDecimal changeAmount) {
        balance = balance.add(changeAmount);
        return balance;
    }

    }

