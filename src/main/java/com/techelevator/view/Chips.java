package com.techelevator.view;

import java.math.BigDecimal;

public class Chips extends VendingMachineItem{

    public Chips (String name, String slotNumber, BigDecimal price) {
        super(name, slotNumber, price);
    }

    @Override
    public String getMessage () {
        return "Crunch, Crunch, Yum!";
    }
}
