
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

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

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Vector record = new Vector();
        String command;
        Caretaker caretaker = new Caretaker();
        Stack commandRecord = new Stack();
        Stack undoList = new Stack();

        CommandFactory[] commands = new CommandFactory[8];
        commands[0] = new ExitFactory();
        commands[1] = new AddFactory();
        commands[2] = new ViewFactory();
        commands[3] = new CollectFactory();
        commands[4] = new ShipFactory();
        commands[5] = new UndoFactory();
        commands[6] = new RedoFactory();
        commands[7] = new ShowListFactory();

        ProductFactory[] products = new ProductFactory[2];
        products[0] = new CoffeeCandyFactory();
        products[1] = new CoffeePowderFactory();

        while (true) {
            System.out.println("Coffee Inventory Management System");
            System.out.println("Please enter command: [a | v | c | s | u | r | sl | x]\n"
                    + "a = add product, v = view products, c = collect product, s = ship product,\n"
                    + "u = undo, r = redo, sl = show list undo/redo, x = exit system\n");
            command = sc.next();
            Command com = createCommand(commands, command, record, products, caretaker, commandRecord, undoList);
            com.execute();
            System.out.println("");
            if (command.equals("a") || command.equals("s") || command.equals("c")) {
                if (command.equals("s")) {
                    if (Ship.class.cast(com).success) {
                        commandRecord.push(com);
                    }
                } else {
                    commandRecord.push(com);
                }
            }
        }
    }

    public static Command createCommand(CommandFactory[] commands, String command, Vector record, ProductFactory[] products, Caretaker caretaker, Stack commandRecord, Stack undoList) {
        Command com;
        switch (command) {
            case "x":
                com = commands[0].CreateCommand(sc, products, record, caretaker, commandRecord, undoList);
                break;
            case "a":
                com = commands[1].CreateCommand(sc, products, record, caretaker, commandRecord, undoList);
                break;
            case "v":
                com = commands[2].CreateCommand(sc, products, record, caretaker, commandRecord, undoList);
                break;
            case "c":
                com = commands[3].CreateCommand(sc, products, record, caretaker, commandRecord, undoList);
                break;
            case "s":
                com = commands[4].CreateCommand(sc, products, record, caretaker, commandRecord, undoList);
                break;
            case "u":
                com = commands[5].CreateCommand(sc, products, record, caretaker, commandRecord, undoList);
                break;
            case "r":
                com = commands[6].CreateCommand(sc, products, record, caretaker, commandRecord, undoList);
                break;
            case "sl":
                com = commands[7].CreateCommand(sc, products, record, caretaker, commandRecord, undoList);
                break;
            default:
                com = null;
        }
        return com;
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
        return "Product information\n"
                + "ID: " + productID + "\n"
                + "Name: " + name + "\n"
                + "Quantity: " + qty + "\n";

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
        return super.toString() + "Number of candies per package: " + noOfCandy + "\n"
                + "Calories Per candy: " + caloriesPerCandy + "\n";
    }

}

class CoffeePowder extends CoffeeProduct {

    private double weight;

    public CoffeePowder(double weight, String name, int productID) {
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
        return super.toString() + "weight: " + weight + "\n";
    }

}
