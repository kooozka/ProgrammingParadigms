package B;

public class CookiesBox extends Trash{
    private double height;
    private double width;
    private double depth;
    public CookiesBox(double height, double width, double depth) {
        super(height * width * depth);
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.material = Material.PAPER;
    }

    @Override
    public String toString() {
        return "Cookies Box " + capacity + "l.";
    }
}
