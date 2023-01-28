package Iterator;

public abstract class Iterator {
    protected int index = 0;
    public abstract boolean end();
    public abstract void next();
    public abstract void prev();
    public abstract Object first();
    public abstract Object current();
}
