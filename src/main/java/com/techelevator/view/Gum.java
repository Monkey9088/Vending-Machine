package com.techelevator.view;

import java.math.BigDecimal;

public class Gum extends VendingMachineItem{
    public Gum (String name, String slotNumber, BigDecimal price) {
        super(name, slotNumber, price);
    }

    @Override
    public String getMessage () {
        return "Chew, Chew, Yum!";
    }
}
