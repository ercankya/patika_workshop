import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Filmler> filmlers=null;
        Filmler filmler = new Filmler("Şakir",1020);
        Filmler filmler2 = new Filmler("hello",120);
        Filmler filmler3 = new Filmler("mother",1060);
        filmlers.add(filmler);
        filmlers.add(filmler2);
        filmlers.add(filmler3);
        FilmUygulamasi filmUygulamasi = new FilmUygulamasi();
        Kullanici kullanici = new Kullanici(9000,"Ercan KAYA",null);
        filmUygulamasi.filmListele();
        Abone abone = filmUygulamasi.aboneOl(kullanici);
        abone.krediAl(1000);
        abone.satinAl(filmler2);
    }
}
