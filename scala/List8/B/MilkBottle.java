package B;

public class MilkBottle extends Trash{
    private double radius;
    private double height;
    public MilkBottle(double radius, double height) {
        super(Math.PI * radius * radius * height);
        this.radius = radius;
        this.height = height;
        this.material = Material.GLASS;
    }

    @Override
    public String toString() {
        return "Milk Bottle " + capacity + "l.";
    }
}
