
import java.util.*;

public interface Command {

    abstract public void execute();

    abstract public void undo();

    abstract public void redo();

    abstract public String toString();
}

class Add implements Command {

    Scanner sc;
    ProductFactory[] products;
    CoffeeProduct product;
    Vector record;

    public Add(Scanner sc, ProductFactory[] products, Vector record) {
        this.sc = sc;
        this.products = products;
        this.record = record;
    }

    @Override
    public void execute() {
        System.out.println("Enter Coffee type (cc=Coffee Candy/cp=Coffee Powder):");
        String type = sc.next();
        if (type.equals("cc")) {
            System.out.println("Enter product id, name, number of candy and calories per candy:");
            sc.nextLine();
            String details = sc.nextLine();
            product = products[0].createProduct(details);
        } else if (type.equals("cp")) {
            System.out.println("Enter product id, name and weight(g):");
            sc.nextLine();
            String details = sc.nextLine();
            product = products[1].createProduct(details);
        }
        record.add(product);
        System.out.println("New product record created.");

    }

    @Override
    public void undo() {
        record.remove(product);
    }

    @Override
    public void redo() {
        record.add(product);
    }

    public String toString() {
        return "Add " + product.getProductID() + " " + product.getName();
    }

}

class View implements Command {

    Scanner sc;
    Vector<CoffeeProduct> record;

    public View(Scanner sc, Vector record) {
        this.sc = sc;
        this.record = record;
    }

    @Override
    public void execute() {
        System.out.println("Enter product id (* to show all):\n");
        String type = sc.next();

        if (type.equals("*")) {
            System.out.println("Coffee Product information");
            System.out.println("ID\tName\tQuantity\tOther Info");
            for (int i = 0; i < record.size(); i++) {
                if (record.get(i) instanceof CoffeeCandy) {
                    System.out.println(record.get(i).getProductID() + "\t" + record.get(i).getName() + "\t" + record.get(i).getQty() + "\t" + CoffeeCandy.class.cast(record.get(i)).getNoOfCandy() + " candy per package (" + CoffeeCandy.class.cast(record.get(i)).getCaloriesPerCandy() + " calories each)");
                } else if (record.get(i) instanceof CoffeePowder) {
                    System.out.println(record.get(i).getProductID() + "\t" + record.get(i).getName() + "\t" + record.get(i).getQty() + "\t" + CoffeePowder.class.cast(record.get(i)).getWeight() + "g");

                }
            }
        } else {
            for (int i = 0; i < record.size(); i++) {
                if (Integer.parseInt(type) == record.get(i).getProductID()) {
                    System.out.println(record.get(i).toString());
                }
            }
        }
    }

    @Override
    public void undo() {
    }

    @Override
    public void redo() {
    }

}

class Collect implements Command {

    Scanner sc;
    Vector<CoffeeProduct> record;
    Caretaker caretaker;
    CoffeeProduct product;

    public Collect(Scanner sc, Vector record, Caretaker caretaker) {
        this.sc = sc;
        this.record = record;
        this.caretaker = caretaker;
    }

    @Override
    public void execute() {
        System.out.println("Enter code:");
        String code = sc.next();

        for (int i = 0; i < record.size(); i++) {
            if (Integer.parseInt(code) == record.get(i).getProductID()) {
                product = record.get(i);
                System.out.println("Quantity to receive:");
                int qty = sc.nextInt();
                caretaker.saveMyClass(record.get(i));
                record.get(i).setQty(record.get(i).getQty() + qty);
                if (record.get(i) instanceof CoffeeCandy) {
                    System.out.println("Received " + qty + " packs of " + record.get(i).getName() + ". Current quantity is " + record.get(i).getQty() + ".");
                } else if (record.get(i) instanceof CoffeePowder) {
                    System.out.println("Received " + qty + " packs of " + record.get(i).getName() + " Current quantity is " + record.get(i).getQty() + ".");
                }
            }
        }
    }

    @Override
    public void undo() {
        caretaker.undo();
    }

    @Override
    public void redo() {
        caretaker.redo();
    }

    public String toString() {
        return "Received " + product.getQty() + " " + product.getName() + " (" + product.getProductID() + ")";
    }

}

class Ship implements Command {

    Scanner sc;
    Vector<CoffeeProduct> record;
    Caretaker caretaker;
    CoffeeProduct product;

    public Ship(Scanner sc, Vector record, Caretaker caretaker) {
        this.sc = sc;
        this.record = record;
        this.caretaker = caretaker;
    }

    @Override
    public void execute() {
        System.out.println("Enter code:");
        String code = sc.next();

        for (int i = 0; i < record.size(); i++) {
            if (Integer.parseInt(code) == record.get(i).getProductID()) {
                product = record.get(i);
                System.out.println("Quantity to ship:");
                int qty = sc.nextInt();
                if (record.get(i).getQty() - qty > 0) {
                    caretaker.saveMyClass(record.get(i));
                    record.get(i).setQty(record.get(i).getQty() - qty);
                    if (record.get(i) instanceof CoffeeCandy) {
                        System.out.println("Shipped " + qty + " packs of " + record.get(i).getName() + ". Current quantity is " + record.get(i).getQty() + ".");
                    } else {
                        System.out.println("Shipped " + qty + " packs of " + record.get(i).getName() + ". Current quantity is " + record.get(i).getQty() + ".");
                    }
                } else {
                    System.out.println("Invalid quantity (current balance is less than required quantity). Try again!!!");
                }
            }
        }
    }

    @Override
    public void undo() {
        caretaker.undo();
    }

    @Override
    public void redo() {
        caretaker.redo();
    }

    public String toString() {
        return "Shipped " + product.getQty() + " " + product.getName() + " (" + product.getProductID() + ")";
    }

}

class ShowList implements Command {

    Stack<Command> commandRecord;
    Stack<Command> undoList;

    public ShowList(Stack commandRecord, Stack undoList) {
        this.commandRecord = commandRecord;
        this.undoList = undoList;
    }

    @Override
    public void execute() {
        System.out.println("Undo List:");
        if (!commandRecord.isEmpty()) {
            for (Command com : commandRecord) {
                System.out.println(com.toString());
            }
        } else {
            System.out.println("Empty");
        }
        System.out.println("Redo List:");
        if (!undoList.isEmpty()) {
            for (Command com : undoList) {
                System.out.println(com.toString());
            }
        } else {
            System.out.println("Empty");
        }
    }

    @Override
    public void undo() {
    }

    @Override
    public void redo() {
    }

}

class Exit implements Command {

    @Override
    public void execute() {
        System.out.println("Thanks for using Coffee Inventory Management System!!");
        System.exit(0);
    }

    @Override
    public void undo() {
    }

    @Override
    public void redo() {
    }

}

class Undo implements Command {

    Stack commandRecord;
    Stack undoList;
    Command com;

    public Undo(Stack commandRecord, Stack undoList) {
        this.commandRecord = commandRecord;
        this.undoList = undoList;
    }

    @Override
    public void execute() {
        if (!commandRecord.empty()) {
            com = (Command) commandRecord.pop();
            undoList.push(com);
            com.undo();
            System.out.println("undo completed.");
        }
    }

    @Override
    public void undo() {
    }

    @Override
    public void redo() {
    }

}

class Redo implements Command {

    Stack commandRecord;
    Stack undoList;
    Command com;

    public Redo(Stack commandRecord, Stack undoList) {
        this.commandRecord = commandRecord;
        this.undoList = undoList;
    }

    @Override
    public void execute() {
        if (!undoList.empty()) {
            com = (Command) undoList.pop();
            commandRecord.push(com);
            com.undo();
            System.out.println("redo completed.");
        }
    }

    @Override
    public void undo() {
    }

    @Override
    public void redo() {
    }

}
