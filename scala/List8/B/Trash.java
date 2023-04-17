package B;

public abstract class Trash {
    protected Material material;
    protected double capacity;
    public Trash(double capacity){
        this.capacity = capacity;
    }

    public Material getMaterial() {
        return material;
    }

    @Override
    public abstract String toString();
}
