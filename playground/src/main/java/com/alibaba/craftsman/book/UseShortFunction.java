package com.alibaba.craftsman.book;

import java.util.List;

/**
 * UseShortFunction
 *
 * @author Frank Zhang
 * @date 2018-09-11 6:12 PM
 */
public class UseShortFunction {

    public void pay(List<Employee> employees){
        for (Employee e: employees){
            if(e.isPayDay()){
                Money pay = e.calculatePay();
                e.deliverPay(pay);
            }
        }
    }
}

class ShortFunction{
    public void pay(List<Employee> employees){
        for (Employee e: employees){
            payIfNecessary(e);
        }
    }

    private void payIfNecessary(Employee e) {
        if(e.isPayDay()){
            calculateAndDeliverPay(e);
        }
    }

    private void calculateAndDeliverPay(Employee e) {
        Money pay = e.calculatePay();
        e.deliverPay(pay);
    }
}


class Employee {

    public boolean isPayDay(){
        return true;
    }

    public Money calculatePay(){
        return null;
    }

    public void deliverPay(Money pay){

    }
}