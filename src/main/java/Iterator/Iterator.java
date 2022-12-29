package Iterator;

public abstract class Iterator {
    protected int index = 0;
    abstract boolean end();
    abstract void next();
    abstract void prev();
    abstract Object first();
    abstract Object current();
}
