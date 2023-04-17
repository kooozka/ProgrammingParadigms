package A;

public class PaperTrash extends Trash {
    public PaperTrash(double capacity) {
        super(capacity);
    }

    @Override
    public String toString(){
        return getClass().getName() + " " + capacity + "l.";
    }
}
