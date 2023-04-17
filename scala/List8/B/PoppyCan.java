package B;

public class PoppyCan extends Trash{
    private double radius;
    private double height;
    public PoppyCan(double radius, double height) {
        super(Math.PI * radius * radius * height);
        this.radius = radius;
        this.height = height;
        this.material = Material.METAL;
    }

    @Override
    public String toString() {
        return "Poppy Can " + capacity + "l.";
    }
}
