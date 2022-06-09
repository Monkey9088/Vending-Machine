package com.techelevator.view;

import java.math.BigDecimal;

public class Slot implements Itemable{
    //Attributes
    private String slotNumber;
    private String itemInResidence;
    private BigDecimal itemInResidencePrice;
    private int maxCapacity = 5;
    private int currentNumberOfItems;
    private boolean full;
    private boolean empty;
    private boolean partiallyStocked;

    //Constructors
    public Slot(String slotNumber, String itemInResidence, BigDecimal itemInResidencePrice, int currentNumberOfItems) {
        this.slotNumber = slotNumber;
        this.itemInResidence = itemInResidence;
        this.itemInResidencePrice = itemInResidencePrice;
        this.currentNumberOfItems = currentNumberOfItems;
    }

    //Getters
    public String getSlotNumber() {
        return slotNumber;
    }
    public String getItemInResidence() {
        return itemInResidence;
    }
    public BigDecimal getItemInResidencePrice() {
        return itemInResidencePrice;
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
    public String getName(VendingMachineItem item) {
        if (slotNumber.equals(item.getSlotNumber())) {
            return item.getName();
        }
        return item.getName();
    }
    public BigDecimal getPrice(VendingMachineItem item) {
        if (slotNumber.equals(item.getSlotNumber())) {
            return item.getPrice();
        }
        return item.getPrice();
    }
}
