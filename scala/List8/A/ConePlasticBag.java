package A;

public class ConePlasticBag extends PlasticTrash {
    public ConePlasticBag(double capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        return "Cone Plastic Bag " + capacity + "l.";
    }
}
