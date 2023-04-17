package A;

public class MilkBox extends PaperPlasticTrash {
    public MilkBox(double height, double width, double depth) {
        super(height * width * depth);
    }

    @Override
    public String toString() {
        return "Milk Box " + capacity + "l.";
    }
}
