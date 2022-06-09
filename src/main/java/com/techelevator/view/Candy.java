package com.techelevator.view;

import java.math.BigDecimal;

public class Candy  extends VendingMachineItem{
    public Candy (String name, String slotNumber, BigDecimal price) {
        super(name, slotNumber, price);
    }

    @Override
    public String getMessage () {
        return "Munch, Munch, Yum!";
    }
}
