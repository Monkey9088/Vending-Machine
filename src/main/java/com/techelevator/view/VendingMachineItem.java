package com.techelevator.view;

import java.math.BigDecimal;
import java.util.ArrayList;

public class VendingMachineItem {

    //Attributes
    private BigDecimal price = new BigDecimal("0.00");
    private String name;
    private String slotNumber;
    //private String type;
    //private int count;

    //Getters
    public BigDecimal getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public String getSlotNumber() {
        return slotNumber;
    }
    //public int getCount(){ return count;}


    //Setters
    public void setCount(int count){
        //this.count = count;
    }

    //Constructors
    public VendingMachineItem (String name, String slotNumber, BigDecimal price,String type;) {
        this.name = name;
        this.price = price;
        this.slotNumber = slotNumber;
        //this.type=type;
       // count =5;
    }

    //Methods
    protected String getMessage() {
        return "Custom message";
    }

}
