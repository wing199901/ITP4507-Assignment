
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 180042945
 */
public abstract class ProductFactory {

    public abstract CoffeeProduct createProduct(String detail);

}

class CoffeeCandyFactory extends ProductFactory {

    @Override
    public CoffeeProduct createProduct(String detail) {
        String[] details = detail.split(",");
        int productID = Integer.parseInt(details[0].replace(" ", ""));
        String name = details[1];
        int noOfCandy = Integer.parseInt(details[2].replace(" ", ""));
        int caloriesPerCandy = Integer.parseInt(details[3].replace(" ", ""));
        return new CoffeeCandy(noOfCandy, caloriesPerCandy, name, productID);
    }

}

class CoffeePowderFactory extends ProductFactory {

    @Override
    public CoffeeProduct createProduct(String detail) {
        String[] details = detail.split(",");
        double weight = Double.parseDouble(details[2].replace(" ", ""));
        String name = details[1];
        int productID = Integer.parseInt(details[0].replace(" ", ""));
        return new CoffeePowder(weight, name, productID);
    }

}
