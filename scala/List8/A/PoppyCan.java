package A;

import A.MetalTrash;

public class PoppyCan extends MetalTrash {
    private double radius;
    private double height;
    public PoppyCan(double radius, double height) {
        super(Math.PI * radius * radius * height);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Poppy Can " + capacity + "l.";
    }
}
