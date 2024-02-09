import java.util.List;

public class Kullanici {
    private int Id;
    private int krediMiktar;
    private String kullaniciAd;
    public List<Filmler> filmlers;

    public Kullanici(int krediMiktar, String kullaniciAd, List<Filmler> filmlers) {
        this.krediMiktar = krediMiktar;
        this.kullaniciAd = kullaniciAd;
        this.filmlers = filmlers;
    }

    public Kullanici(Kullanici kullanici) {

    }

    public void krediAl(int krediMiktar){
        this.krediMiktar+=krediMiktar;
    }
    public void satinAl(Filmler filmler){
        this.krediMiktar-=filmler.getKrediMaliyet();
        this.filmlers.add(filmler);
    }
    public void talepEt(Filmler filmler){

    }

    public int getId() {
        return Id;
    }

    public int getKrediMiktar() {
        return krediMiktar;
    }

    public void setKrediMiktar(int krediMiktar) {
        this.krediMiktar = krediMiktar;
    }

    public String getKullaniciAd() {
        return kullaniciAd;
    }

    public void setKullaniciAd(String kullaniciAd) {
        this.kullaniciAd = kullaniciAd;
    }

    public List<Filmler> getFilmlers() {
        return filmlers;
    }

    public void setFilmlers(List<Filmler> filmlers) {
        this.filmlers = filmlers;
    }
}
