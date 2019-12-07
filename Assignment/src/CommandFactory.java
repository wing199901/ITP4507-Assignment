
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
public abstract class CommandFactory {

    public abstract Command CreateCommand(Scanner sc, ProductFactory[] products, Vector record, Caretaker caretaker, Stack commandRecord, Stack undoList);
}

class ExitFactory extends CommandFactory {

    @Override
    public Command CreateCommand(Scanner sc, ProductFactory[] products, Vector record, Caretaker caretaker, Stack commandRecord, Stack undoList) {
        return new Exit();
    }

}

class AddFactory extends CommandFactory {

    @Override
    public Command CreateCommand(Scanner sc, ProductFactory[] products, Vector record, Caretaker caretaker, Stack commandRecord, Stack undoList) {
        return new Add(sc, products, record);
    }

}

class ViewFactory extends CommandFactory {

    @Override
    public Command CreateCommand(Scanner sc, ProductFactory[] products, Vector record, Caretaker caretaker, Stack commandRecord, Stack undoList) {
        return new View(sc, record);
    }

}

class CollectFactory extends CommandFactory {

    @Override
    public Command CreateCommand(Scanner sc, ProductFactory[] products, Vector record, Caretaker caretaker, Stack commandRecord, Stack undoList) {
        return new Collect(sc, record, caretaker);
    }

}

class ShipFactory extends CommandFactory {

    @Override
    public Command CreateCommand(Scanner sc, ProductFactory[] products, Vector record, Caretaker caretaker, Stack commandRecord, Stack undoList) {
        return new Ship(sc, record, caretaker);
    }

}

class UndoFactory extends CommandFactory {

    @Override
    public Command CreateCommand(Scanner sc, ProductFactory[] products, Vector record, Caretaker caretaker, Stack commandRecord, Stack undoList) {
        return new Undo(commandRecord, undoList);
    }

}

class RedoFactory extends CommandFactory {

    @Override
    public Command CreateCommand(Scanner sc, ProductFactory[] products, Vector record, Caretaker caretaker, Stack commandRecord, Stack undoList) {
        return new Redo(commandRecord, undoList);
    }

}

class ShowListFactory extends CommandFactory {

    @Override
    public Command CreateCommand(Scanner sc, ProductFactory[] products, Vector record, Caretaker caretaker, Stack commandRecord, Stack undoList) {
        return new ShowList(commandRecord, undoList);
    }

}
