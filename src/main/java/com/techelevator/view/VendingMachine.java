package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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



    //Return change and set balance to 0.00
    public void giveChange() {
        double change = balance.doubleValue();
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
        LocalDateTime time =  LocalDateTime.now();
        String logMessage = time + " GIVE CHANGE: $" + change + " " + "$" + 0.00;
        logTransactions(logMessage);

        System.out.println("Here's your change! $" + balance + ": " + quarterCount + " Quarters, " + dimeCount + " Dimes, " + nickelCount + " Nickles.");
        balance = new BigDecimal("0.00");
    }

    //write to Log.txt every time money is fed into the machine or a purchase is made
    //If Log.txt doesn't exist, create the file and write to it
    //Else Append Log.txt
    public void logTransactions(String log) {
        String logPath = "Log.txt";
        File transactions = new File(logPath);

        try (PrintWriter newWriter = new PrintWriter(transactions )) {
            if (!transactions.exists()) {
                transactions.createNewFile();
                newWriter.println(log);
            }else{
                PrintWriter addWriter =new PrintWriter(new FileOutputStream(transactions,true));
                addWriter.println(log);
            }

        }catch (FileNotFoundException ex) {
            System.out.println("File does not exists");;
        } catch (IOException ex) {
            System.out.println("Error occurred while creating the file");
        }
    }








    //Feed money
    public void addToBalance(int changeAmount) {
        balance = balance.add(new BigDecimal(changeAmount));
        LocalDateTime time =  LocalDateTime.now();
        String logMessage = time + " FEED MONEY: $" + changeAmount + " " + "$" + balance;
        logTransactions(logMessage);




        }
        public void dispenseItem(String slotId){
        boolean isValidCode = false;
        for(Slot s : slots){
            if(s.getSlotNumber().equals(slotId)){
                isValidCode = true;
                if(s.getCurrentNumberOfItems()>0){
                    if(balance.compareTo(s.getItem().getPrice())>=0){
                        System.out.println(s.getItem().getName() + " | $" + s.getItem().getPrice() + " | $" +
                                (balance.subtract(s.getItem().getPrice())) + " | ");
                        printMessage(s.getItem().getType());

                        balance = balance.subtract(s.getItem().getPrice());
                        s.setCurrentNumberOfItems(s.getCurrentNumberOfItems() - 1);
                        LocalDateTime time = LocalDateTime.now();
                        String logMessage = time + " " + s.getItem().getName() + " " + s.getSlotNumber() + "  $" + s.getItem().getPrice() + " $" + balance;
                        logTransactions(logMessage);
                    } else{
                        System.out.println("Please feed more money");
                    }
                }else{
                    System.out.println("The product is sold out, please choose another item");
                }
            }

        }if(!isValidCode){
                System.out.println("Invalid slot number, please try again");
            }

        }


    private void printMessage(String itemType) {
        if (itemType.equals("Chip")) {
            System.out.println("Crunch, Crunch, Yum!");
        }
        if (itemType.equals("Candy")) {
            System.out.println("Munch, Munch, Mmm-Good!");
        }
        if (itemType.equals("Drink")) {
            System.out.println("Cheers, Glug, Glug!");
        }
        if (itemType.equals("Gum")) {
            System.out.println("Chew, Chew, Pop!");
        }
    }
}



