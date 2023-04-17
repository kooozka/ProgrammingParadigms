package A;

public class PaperPlasticTrash extends PaperTrash{
    public PaperPlasticTrash(double capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        return "Paper-Plastic trash " + capacity + "l.";
    }
}
