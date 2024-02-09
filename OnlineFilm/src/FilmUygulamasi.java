import java.util.List;

public class FilmUygulamasi {
    private int abonelikMaliyet;
    private List<Filmler> standFilmlers;

    public Abone aboneOl(Kullanici kullanici){
        Abone yeniAbone= (Abone) kullanici;
        yeniAbone.setKrediMiktar(yeniAbone.getKrediMiktar()-getAbonelikMaliyet());
        return yeniAbone;
    }
    public void filmListele(){
        for (Filmler film:standFilmlers) {
            System.out.println("Filmin Id : " +film.getId());
            System.out.println("Filmin Adı : " +film.getName());
            System.out.println("Filmin Maliyeti : " +film.getKrediMaliyet());

        }
        System.out.println("************************************************");
    }
    public void filmSirala(){

    }

    public int getAbonelikMaliyet() {
        return abonelikMaliyet;
    }

    public void setAbonelikMaliyet(int abonelikMaliyet) {
        this.abonelikMaliyet = abonelikMaliyet;
    }

    public List<Filmler> getStandFilmlers() {
        return standFilmlers;
    }

    public void setStandFilmlers(List<Filmler> standFilmlers) {
        this.standFilmlers = standFilmlers;
    }
}
