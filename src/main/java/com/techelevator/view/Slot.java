package com.techelevator.view;

public class Slot {
    //Attributes
    private String slotNumber;
    private int maxCapacity = 5;
    private int currentNumberOfItems;
    private boolean full;
    private boolean empty;
    private boolean partiallyStocked;

    //Constructors

    //Getters
    public String getSlotNumber() {
        return slotNumber;
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
