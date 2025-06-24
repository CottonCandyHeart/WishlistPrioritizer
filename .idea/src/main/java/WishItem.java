package java;

public class WishItem {
    private String name;
    private double price;
    private int priority;  // 1-10
    private String cathegory;

    public WishItem (String name, double price, int priority, String cathegory){
        this.name = name;
        this.price = price;
        this.priority = priority;
        this.cathegory = cathegory;
    }

    @Override
    public String toString(){
        return this.name + "\n" + this.cathegory + "\n" + this.price + " PLN\nPriority: " + this.priority + "\n";
    }

    public String getName(){return this.name;}
    public double getPrice(){return this.price;}
    public int getPriority(){return this.priority;}
    public String getCathegory(){return this.cathegory;}

    public void setName(String name){this.name = name;}
    public void setPrice(double price){this.price = price;}
    public void setPriority(int priority){this.priority = priority;}
    public void setCathegory(String cathegory){this.cathegory = cathegory;}
}
