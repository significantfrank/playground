package com.alibaba.craftsman.book.chapter4;

import static com.alibaba.craftsman.book.chapter4.MakeCoffee.CoffeeType.*;

/**
 * MakeCoffee
 *
 * @author Frank Zhang
 * @date 2019-01-29 5:29 PM
 */
public class MakeCoffee {

    public static enum CoffeeType{
        CAPPUCCINO,
        BLACK,
        MOCHA,
        LATTE,
        ESPRESSO
    }

    public void makeCoffee(boolean isMilkCoffee, boolean isSweetTooth, CoffeeType type) {
        //选择咖啡粉
        pourCoffeePowder(type);
        //加入沸水
        pourWater();
        //选择口味
        flavor(isMilkCoffee, isSweetTooth);
        //搅拌
        stir();
    }

    private void flavor(boolean isMilkCoffee, boolean isSweetTooth) {
        if (isMilkCoffee) {
            pourMilk();
        }
        if (isSweetTooth) {
            addSugar();
        }
    }

    private void pourCoffeePowder(CoffeeType type) {
        if (type == CAPPUCCINO) {
            pourCappuccinoPowder();
        }
        else if (type == BLACK) {
            pourBlackPowder();
        }
        else if (type == MOCHA) {
            pourMochaPowder();
        }
        else if (type == LATTE) {
            pourLattePowder();
        }
        else if (type == ESPRESSO) {
            pourEspressoPowder();
        }
    }


    public void makeCoffee2(boolean isMilkCoffee, boolean isSweetTooth, CoffeeType type) {
        //选择咖啡粉
       if (type == CAPPUCCINO) {
           pourCappuccinoPowder();
       }
       else if (type == BLACK) {
           pourBlackPowder();
       }
       else if (type == MOCHA) {
           pourMochaPowder();
       }
       else if (type == LATTE) {
           pourLattePowder();
       }
       else if (type == ESPRESSO) {
           pourEspressoPowder();
       }
       //加入沸水
       pourWater();
       //选择口味
       if (isMilkCoffee) {
           pourMilk();
       }
       if (isSweetTooth) {
           addSugar();
       }
       //搅拌
       stir();
    }

    private void stir() {
    }

    private void pourWater() {
    }

    private void pourBlackPowder() {
    }

    private void pourCappuccinoPowder() {

    }
    private void pourMochaPowder(){

    }
    private void pourLattePowder(){

    }
    private void pourEspressoPowder(){

    }
    private void pourMilk(){

    }
    private void addSugar(){

    }
}
