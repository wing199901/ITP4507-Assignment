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
        System.out.println("Coffee Inventory Management System");
        System.out.println("Please enter command: [a | v | c | s | u | r | sl | x]\n"
                + "a = add product, v = view products, c = collect product, s = ship product, u = undo, r = redo, sl = show list undo/redo, x = exit system");

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

    public abstract String getName();

    public abstract void setName(String name);

    public abstract int getProductID();

    public abstract void setProductID(int productID);

    public abstract int getQty();

    public abstract void setQty(int qty);

    @Override
    public String toString() {
        return "CoffeeProduct{" + "name=" + name + ", productID=" + productID + ", qty=" + qty + '}';
    }

}

class CoffeeCandy extends CoffeeProduct {

    private int noOfCandy;
    private int caloriesPerCandy;

    public CoffeeCandy(int noOfCandy, int caloriesPerCandy, String name, int productID) {
        super(name, productID, 0);
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
        return super.toString() + "CoffeeCandy{" + "noOfCandy=" + noOfCandy + ", caloriesPerCandy=" + caloriesPerCandy + '}';
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getProductID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setProductID(int productID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getQty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setQty(int qty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

class CoffeeProwder extends CoffeeProduct {

    private double weight;

    public CoffeeProwder(double weight, String name, int productID) {
        super(name, productID, 0);
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
        return super.toString() + "CoffeeProwder{" + "weight=" + weight + '}';
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getProductID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setProductID(int productID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getQty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setQty(int qty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
