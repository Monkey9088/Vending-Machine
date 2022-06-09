package com.techelevator.view;

import java.math.BigDecimal;

public interface Itemable {
    String getName(VendingMachineItem item);
    BigDecimal getPrice(VendingMachineItem item);
}
