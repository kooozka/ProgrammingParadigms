package B;

public class ConePlasticBag extends Trash{
    public ConePlasticBag(double capacity) {
        super(capacity);
        this.material = Material.PLASTIC;
    }

    @Override
    public String toString() {
        return "Cone Plastic Bag " + capacity + "l.";
    }
}
