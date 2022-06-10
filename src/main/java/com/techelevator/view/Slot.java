package com.techelevator.view;

import java.math.BigDecimal;

public class Slot {
    //Attributes
    private String slotNumber;
//    private String itemInResidence;
//    private BigDecimal itemInResidencePrice;
    private VendingMachineItem item;
    private int maxCapacity = 5;
    private int currentNumberOfItems;
    private boolean full;
    private boolean empty;
    private boolean partiallyStocked;

    //Constructors
    public Slot(String slotNumber, VendingMachineItem item, int currentNumberOfItems) {
        this.slotNumber = slotNumber;
        this.item = item;
        this.currentNumberOfItems = currentNumberOfItems;
    }

    //Getters
    public String getSlotNumber() {
        return slotNumber;
    }
    public VendingMachineItem getItem() {
        return item;
    }
    public boolean isFull() {
        return full;
    }
    public boolean isEmpty() {
        return empty;
    }
    public boolean isPartiallyStocked() {
        return partiallyStocked;
    }
    public int getCurrentNumberOfItems() {
        return currentNumberOfItems;
    }

    //Setters
    public void setCurrentNumberOfItems(int currentNumberOfItems) {
        this.currentNumberOfItems = currentNumberOfItems;
    }

    //Methods

}
