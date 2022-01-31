package exceptions;

public class OutOfStock extends Exception {
    public OutOfStock(String name, int available, int needed) {
        super(name + "; only " + available + " left; need " + needed);
    }
}
