import java.util.List;

public class Abone extends Kullanici{
    public List<Filmler> filmlers;

    public Abone(int krediMiktar, String kullaniciAd, List<Filmler> filmlers) {
        super(krediMiktar, kullaniciAd, filmlers);
    }

    public void kirala(Filmler filmler){
        this.setKrediMiktar(this.getKrediMiktar()-filmler.getKrediMaliyet());
        this.filmlers.add(filmler);
    }
}
