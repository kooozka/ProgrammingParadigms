package A;

import java.util.ArrayList;
import java.util.List;

public class PolymorphicSortingCentre {
    private List<MetalTrash> metalTrashes;
    private List<GlassTrash> glassTrashes;
    private List<PaperTrash> paperTrashes;
    private List<PlasticTrash> plasticTrashes;
    private List<PaperPlasticTrash> paperPlasticTrashes;

    public PolymorphicSortingCentre(){
        metalTrashes = new ArrayList<>();
        glassTrashes = new ArrayList<>();
        paperTrashes = new ArrayList<>();
        plasticTrashes = new ArrayList<>();
        paperPlasticTrashes = new ArrayList<>();
    }

    public void addSomeTrashes(Trash trash){
        if(trash instanceof MetalTrash)
            metalTrashes.add((MetalTrash) trash);
        else if(trash instanceof GlassTrash)
            glassTrashes.add((GlassTrash) trash);
        else if(trash instanceof PaperTrash) {
            if(trash instanceof PaperPlasticTrash)
                paperPlasticTrashes.add((PaperPlasticTrash) trash);
            else
                paperTrashes.add((PaperTrash) trash);
        }
        else if(trash instanceof PlasticTrash)
            plasticTrashes.add((PlasticTrash) trash);
    }

    public void readPlasticTrashes(){
        System.out.println("--------PLASTIC TRASHES--------");
        for(PlasticTrash trash : plasticTrashes)
            System.out.println(trash);
    }
    public void readPaperTrashes(){
        System.out.println("--------PAPER TRASHES--------");
        for(PaperTrash trash : paperTrashes)
            System.out.println(trash);
    }
    public void readMetalTrashes(){
        System.out.println("--------METAL TRASHES--------");
        for(MetalTrash trash : metalTrashes)
            System.out.println(trash);
    }
    public void readGlassTrashes(){
        System.out.println("--------GLASS TRASHES--------");
        for(GlassTrash trash : glassTrashes)
            System.out.println(trash);
    }

    public void readPaperPlasticTrashes(){
        System.out.println("--------PAPER-PLASTIC TRASHES--------");
        for(PaperPlasticTrash trash : paperPlasticTrashes)
            System.out.println(trash);
        }
}
