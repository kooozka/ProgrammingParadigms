package A;

public class PlasticTrash extends Trash {
    public PlasticTrash(double capacity) {
        super(capacity);
    }

    @Override
    public String toString(){
        return "Plastic trash " + capacity + "l.";
    }
}
