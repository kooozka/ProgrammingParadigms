package B;

public class MilkBox extends Trash{
    private double height;
    private double width;
    private double depth;

    public MilkBox(double height, double width, double depth) {
        super(height * width * depth);
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.material = Material.METALIZED_PAPER;
    }


    @Override
    public String toString() {
        return "Milk Box " + capacity + "l.";
    }
}
