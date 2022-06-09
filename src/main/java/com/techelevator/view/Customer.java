package com.techelevator.view;

import java.math.BigDecimal;
import java.util.List;

public class Customer {
    //properties
    private BigDecimal totalBalance;
    private List<VendingMachineItem> boughtItems;

    public Customer(){

    }

    public BigDecimal getTotalBalance() {
        return totalBalance;
    }

    public List<VendingMachineItem> getBoughtItems() {
        return boughtItems;
    }

    public void setTotalBalance(BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
    }

    public void setBoughtItems(List<VendingMachineItem> boughtItems) {
        this.boughtItems = boughtItems;
    }
}
