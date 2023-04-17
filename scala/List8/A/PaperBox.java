package A;

public class PaperBox extends PaperTrash {
    private double height;
    private double width;
    private double depth;

    public PaperBox(double height, double width, double depth) {
        super(height * width * depth);
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
