package com.example.wishlistprioritizer;

import java.time.LocalDate;

public class WishItem implements Comparable<WishItem> {
    private String name;
    private double price;
    private int priority;  // 1-10
    private String cathegory;
    private LocalDate date;

    public WishItem (String name, double price, int priority, String cathegory){
        this.name = name;
        this.price = price;
        this.priority = priority;
        this.cathegory = cathegory;
        this.date = LocalDate.now();
    }

    public int compareTo(WishItem wishItem){
        return Double.compare(this.price, wishItem.price);
    }

    @Override
    public String toString(){
        return this.name + "\n" + this.cathegory + "\n" + this.price + " PLN\nPriority: " + this.priority + "\n" + this.date;
    }

    public String getName(){return this.name;}
    public double getPrice(){return this.price;}
    public int getPriority(){return this.priority;}
    public String getCathegory(){return this.cathegory;}
    public LocalDate getDate(){return this.date;}

    public void setName(String name){this.name = name;}
    public void setPrice(double price){this.price = price;}
    public void setPriority(int priority){this.priority = priority;}
    public void setCathegory(String cathegory){this.cathegory = cathegory;}
    public void setDate(LocalDate date){this.date = date;}
}
