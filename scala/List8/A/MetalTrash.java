package A;

public class MetalTrash extends Trash {
    public MetalTrash(double capacity) {
        super(capacity);
    }

    @Override
    public String toString(){
        return "Metal trash " + capacity + "l.";
    };
}
