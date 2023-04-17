package A;

public abstract class Trash {
    protected double capacity;

    public Trash(double capacity){
        this.capacity = capacity;
    }
    @Override
    public abstract String toString();
}
