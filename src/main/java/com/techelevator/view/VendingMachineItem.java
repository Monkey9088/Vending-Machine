package com.techelevator.view;

import java.math.BigDecimal;
import java.util.ArrayList;

public class VendingMachineItem {

    //Attributes
    private BigDecimal price = new BigDecimal("0.00");
    private String name;
    private String slotNumber;
    private String type;

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
    public String getType() {
        return type;
    }


    //Setters

    //Constructors
    public VendingMachineItem (String name, String type, String slotNumber, BigDecimal price) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.slotNumber = slotNumber;
    }

//    //Methods
//    //protected String getMessage() {
//        return "Custom message";
//    }

}
