/**
 * Bottle.java
 * @author Aino Liukkonen
 */

package com.example.bottledispenser;

public class Bottle {
    private String name;
    private String manufacturer;
    private double size;
    private double price;

    public Bottle(){
        name = "Pepsi Max";
        size = 0.5;
        price = 1.80;
    }

    public Bottle(String n, double sz, double pr){
        name = n;
        size = sz;
        price = pr;
    }

    public String getName(){
        return name;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public double getSize(){
        return size;
    }

    public double getPrice(){
        return price;
    }
}
