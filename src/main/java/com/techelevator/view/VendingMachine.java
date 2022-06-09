package com.techelevator.view;

import java.math.BigDecimal;
import java.util.List;

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

    //Create list from each line of the file.  For each line in list:
    //Split the line at |s and add to array
    //Make if statement to create new vending machine item based on type at [4] and set slot, name, and price based on [0], [1], & [2] respectively

    //Stoking method: Create new instances of slots, fill them with the items from the stock list, and add those full slots to the slots list

    //write to Log.txt every time money is fed into the machine or a purchase is made
    //If Log.txt doesn't exist, create the file and write to it
    //Else Append Log.txt

    //Dispenses items from slots when purchased

    //Override toString method so that toString() generates a String that will display Slot number of item, name of item,
    //quantity of item, and price of item for each item in the stock list

    //Return change and set balance to 0.00


}
