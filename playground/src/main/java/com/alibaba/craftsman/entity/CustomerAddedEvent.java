package com.alibaba.craftsman.entity;

import com.alibaba.cola.event.DomainEventI;

/**
 * CustomerAddedEvent
 *
 * @author Frank Zhang
 * @date 2019-01-13 4:20 PM
 */
public class CustomerAddedEvent implements DomainEventI {
    Customer customer;

    public CustomerAddedEvent(Customer customer) {
        this.customer = customer;
    }
}
