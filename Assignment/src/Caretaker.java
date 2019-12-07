
import java.util.*;

public class Caretaker {

    private Stack undoList = new Stack();
    private Stack redoList = new Stack();

    public void saveMyClass(CoffeeProduct mc) {
        redoList.clear();
        Memento amemento = new Memento(mc);
        undoList.push(amemento);
    }

    public void undo() {
        if (!undoList.isEmpty()) {
            System.out.println("Perform undo.");
            Memento m = (Memento) undoList.pop();
            Memento redomemento = new Memento(m.myClass);
            redoList.push(redomemento);
            m.restore();
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (!redoList.isEmpty()) {
            System.out.println("Perform redo.");
            Memento m = (Memento) redoList.pop();
            Memento undomemento = new Memento(m.myClass);
            undoList.push(undomemento);
            m.restore();
        } else {
            System.out.println("Nothing to redo.");
        }
    }

}
