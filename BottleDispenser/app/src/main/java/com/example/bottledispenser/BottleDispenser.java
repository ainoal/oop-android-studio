/**
 * BottleDispenser.java
 * @author Aino Liukkonen
 */

package com.example.bottledispenser;

import java.util.ArrayList;
import android.widget.TextView;

public class BottleDispenser {
    private static int bottles;
    private double money;
    private static ArrayList<Bottle> bottleList;
    private String name;
    private double price;
    String moneyString = null;

    private static BottleDispenser bd = new BottleDispenser();


    private BottleDispenser() {
        bottles = 5; // 5 bottles -1 because index starts at 0
        money = 0.00;

        bottleList= new ArrayList<Bottle>();

        bottleList.add(new Bottle());
        bottleList.add(new Bottle("Pepsi Max", 1.5, 2.2));
        bottleList.add(new Bottle("Coca-Cola Zero", 0.5, 2.0));
        bottleList.add(new Bottle("Coca-Cola Zero", 1.5, 2.5));
        bottleList.add(new Bottle("Fanta Zero", 0.5, 1.95));
    }

    public static BottleDispenser getInstance() {
        return bd;
    }

    public static void addBottle(Bottle b) {
        bottles += 1;
        bottleList.add(b);
    }

    public void rmvBottle(int index) {
        bottles -= 1;
        bottleList.remove(index);
    }

    public void addMoney(TextView textView, TextView textView2, double value) {
        money += value;
        textView2.setText("Klink! Added more money!");
        moneyString = String.format("%.2f€", money);
        textView.setText(moneyString);
    }

    public void buyBottle(int index, TextView textView, TextView textView2) {

        if (bottles == 0) {
            returnMoney(textView, textView2);
            textView2.setText("Sorry, we are temporarily out of drinks");
        }
        else if (money <= price) {
            textView2.setText("Add money first!");
        }
        else {
            name = bottleList.get(index).getName();
            price = bottleList.get(index).getPrice();
            money -= price;
            this.rmvBottle(index);
            textView2.setText("KACHUNK! " + name + " came out of the dispenser!");
            moneyString = String.format("%.2f€", money);
            textView.setText(moneyString);
        }
    }

    public void returnMoney(TextView textView, TextView textView2) {
        moneyString = String.format("%.2f€", money);
        textView2.setText("Klink klink. Money came out! You got "+ moneyString + " back");
        money = 0.00;
        moneyString = String.format("%.2f€", money);
        textView.setText(moneyString);
    }

    public void listBottles() {
        int counter = 0;

        for (Bottle o: bottleList) {
            String nm = o.getName();
            double sz = o.getSize();
            double pr = o.getPrice();
            counter += 1;

            System.out.println(counter + ". Name: " + nm);
            System.out.println("\tSize: " + sz + "\tPrice: " + pr);
        }
    }
}
