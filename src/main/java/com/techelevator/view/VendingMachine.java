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
    private List<VendingMachineItem> stock;
    private List<Slot> slots;


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
    private List<VendingMachineItem> inventoryItems() {
        String path = "C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-orange-team-3\\vendingmachine.csv";
        File inventoryFile = new File(path);
        List<VendingMachineItem> items = new ArrayList<>();
        VendingMachineItem item = new VendingMachineItem("", "", new BigDecimal(0.00));
        try (Scanner fileReader = new Scanner(inventoryFile)) {
            while (fileReader.hasNextLine()) {
                String currentLine = fileReader.nextLine();
                String[] itemInfo = new String[4];
                itemInfo = currentLine.split("\\|");
                if (itemInfo[4].equals("Chips")) {
                    Chips newChips = new Chips(itemInfo[1], itemInfo[0], new BigDecimal(itemInfo[2]));
                    items.add(newChips);
                }
                if (itemInfo[4].equals("Candy")) {
                    Candy newCandys = new Candy(itemInfo[1], itemInfo[0], new BigDecimal(itemInfo[2]));
                    items.add(newCandys);
                }
                if (itemInfo[4].equals("Gum")) {
                    Gum newGums = new Gum(itemInfo[1], itemInfo[0], new BigDecimal(itemInfo[2]));
                    items.add(newGums);
                }
                if (itemInfo[4].equals("Drink")) {
                    Drink newDrinks = new Drink(itemInfo[1], itemInfo[0], new BigDecimal(itemInfo[2]));
                    items.add(newDrinks);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }return items;
    }


        //Stoking method: Create new instances of slots, fill them with the items from the stock list, and add those full slots to the slots list
       public List<Slot> stock(){


       }
        //write to Log.txt every time money is fed into the machine or a purchase is made
        //If Log.txt doesn't exist, create the file and write to it
        //Else Append Log.txt

        //Dispenses items from slots when purchased

        //Override toString method so that toString() generates a String that will display Slot number of item, name of item,
        //quantity of item, and price of item for each item in the stock list

        //Return change and set balance to 0.00

    }

