
public class Memento {

    CoffeeProduct myClass;
    private int qty;

    public Memento(CoffeeProduct mc) {
        myClass = mc;
        qty = mc.getQty();
    }

    public void restore() {
        myClass.setQty(qty);
    }
}
