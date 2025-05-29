package org.example.ustcshoppingapp;

import java.io.*;
public class Product {
    private String name;
    private String category;
    private int inventory;
    private long price;

    public Product(String name, String category, int inventory, long price) {
        this.name = name;
        this.category = category;
        this.inventory = inventory;
        this.price = price;
    }

    //getter
    public String name() {
        return this.name;
    }

    public String category() {
        return this.category;
    }

    public int inventory() {
        return this.inventory;
    }

    public long price() {
        return this.price;
    }
    public double dprice() {
        return ((double) this.price)/100;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
    public void setPrice(long price) {
        this.price = price;
    }
    public int stock(int stocks) {
        if(stocks < 0) return -1;
        this.inventory += stocks;
        return this.inventory;
    }
    public int sell(int sales) {
        if(this.inventory < sales) return -1;
        this.inventory -= sales;
        return this.inventory;
    }

    //other
    public void info() {
        System.out.println("Name:"+this.name);
        System.out.println("Category:"+this.category);
        System.out.println("Inventory:"+this.inventory);
        System.out.printf("Price:%.2f ￥",this.dprice());
        System.out.println();
    }

    //IO
    public int writeTo(String fileName) throws Exception{
        try(PrintWriter output = new PrintWriter(new File(fileName))) {
            output.printf("Name: %s\n",this.name);
            output.printf("Category: %s\n",this.category);
            output.printf("Inventory: %d\n",this.inventory);
            output.printf("Price: %.2f ￥\n\n",this.dprice());
            return 1;
        }
        catch (Exception ex) {
            return -1;
        }
    }

}

