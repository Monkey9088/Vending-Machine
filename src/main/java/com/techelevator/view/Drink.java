package com.techelevator.view;

import java.math.BigDecimal;

public class Drink extends VendingMachineItem{
    public Drink (String name, String slotNumber, BigDecimal price) {
        super(name, slotNumber, price);
    }

    @Override
    public String getMessage () {
        return "Glug, Glug, Yum!";
    }
}
