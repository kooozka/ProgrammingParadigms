package B;

import java.util.ArrayList;
import java.util.List;

public class SortingCentre {
    private List<Trash> metalTrashes;
    private List<Trash> glassTrashes;
    private List<Trash> paperTrashes;
    private List<Trash> plasticTrashes;
    private List<Trash> paperPlasticTrashes;

    public SortingCentre(){
        metalTrashes = new ArrayList<>();
        glassTrashes = new ArrayList<>();
        paperTrashes = new ArrayList<>();
        plasticTrashes = new ArrayList<>();
        paperPlasticTrashes = new ArrayList<>();
    }

    public void addSomeTrashes(Trash trash){
        if(trash.getMaterial().equals(Material.METAL))
            metalTrashes.add(trash);
        else if(trash.getMaterial().equals(Material.GLASS))
            glassTrashes.add(trash);
        else if(trash.getMaterial().equals(Material.PAPER))
            paperTrashes.add(trash);
        else if(trash.getMaterial().equals(Material.PLASTIC))
            plasticTrashes.add(trash);
        else if(trash.getMaterial().equals(Material.METALIZED_PAPER));
    }

    public void readPlasticTrashes(){
        System.out.println("--------PLASTIC TRASHES--------");
        for(Trash trash : plasticTrashes)
            System.out.println(trash);
    }
    public void readPaperTrashes(){
        System.out.println("--------PAPER TRASHES--------");
        for(Trash trash : paperTrashes)
            System.out.println(trash);
    }
    public void readMetalTrashes(){
        System.out.println("--------METAL TRASHES--------");
        for(Trash trash : metalTrashes)
            System.out.println(trash);
    }
    public void readGlassTrashes(){
        System.out.println("--------GLASS TRASHES--------");
        for(Trash trash : glassTrashes)
            System.out.println(trash);
    }
    public void readPaperPlasticTrashes(){
        System.out.println("--------PAPER_PLASTIC TRASHES--------");
        for(Trash trash : glassTrashes)
            System.out.println(trash);
    }
}
