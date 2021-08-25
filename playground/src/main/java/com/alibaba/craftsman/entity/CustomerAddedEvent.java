package com.alibaba.craftsman.entity;

/**
 * CustomerAddedEvent
 *
 * @author Frank Zhang
 * @date 2019-01-13 4:20 PM
 */
public class CustomerAddedEvent  {
    Customer customer;

    public CustomerAddedEvent(Customer customer) {
        this.customer = customer;
    }
}
