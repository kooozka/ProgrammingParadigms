package A;

public class GlassTrash extends Trash {
    public GlassTrash(double capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + capacity + "l.";
    }
}
