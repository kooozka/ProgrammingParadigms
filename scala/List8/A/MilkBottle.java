package A;

import A.GlassTrash;

public class MilkBottle extends GlassTrash {
    private double radius;
    private double height;
    public MilkBottle(double radius, double height) {
        super(Math.PI * radius * radius * height);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
