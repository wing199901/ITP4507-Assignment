/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 180042945
 */
public class Assignment {

    public static void main(String[] args) {

    }
}

abstract class CoffeeProduct {

    private String name;
    private int productID;
    private int qty;

    public CoffeeProduct(String name, int productID, int qty) {
        this.name = name;
        this.productID = productID;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "CoffeeProduct{" + "name=" + name + ", productID=" + productID + ", qty=" + qty + '}';
    }

}

class CoffeeCandy extends CoffeeProduct {

    private int noOfCandy;
    private int caloriesPerCandy;

    public CoffeeCandy(int noOfCandy, int caloriesPerCandy, String name, int productID, int qty) {
        super(name, productID, qty);
        this.noOfCandy = noOfCandy;
        this.caloriesPerCandy = caloriesPerCandy;
    }

    public int getNoOfCandy() {
        return noOfCandy;
    }

    public void setNoOfCandy(int noOfCandy) {
        this.noOfCandy = noOfCandy;
    }

    public int getCaloriesPerCandy() {
        return caloriesPerCandy;
    }

    public void setCaloriesPerCandy(int caloriesPerCandy) {
        this.caloriesPerCandy = caloriesPerCandy;
    }

    @Override
    public String toString() {
        return "CoffeeCandy{" + "noOfCandy=" + noOfCandy + ", caloriesPerCandy=" + caloriesPerCandy + '}';
    }

}

class CoffeeProwder extends CoffeeProduct {

    private double weight;

    public CoffeeProwder(double weight, String name, int productID, int qty) {
        super(name, productID, qty);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "CoffeeProwder{" + "weight=" + weight + '}';
    }

}
