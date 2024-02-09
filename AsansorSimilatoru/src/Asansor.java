import javax.persistence.*;

@Entity
public class Asansor {
    @Id
    @GeneratedValue(generator = "idGenerator", strategy = GenerationType.AUTO)
    private long Id;
    final private int kapasite = 6;
    private int konumKat;
    private int süre;
    private boolean kilitle = true;

    public Asansor(int konumKat, int süre) {
        this.konumKat = konumKat;
        this.süre = süre;
    }

    public boolean enerjiTasarruf() {
        return basildiMi();
    }

    public boolean basildiMi() {
        return true;
    }

    public boolean doluMu() {
        return true;
    }

    public void asagiGit() {
        setKilitle(true);
    }

    public void yukariGit() {
        setKilitle(true);
    }

    public void kapiAc() {
        setKilitle(false);
    }

    public void kapiKapa() {
        setKilitle(true);
    }

    public void asansorKataGeldi() {
        zilCal();
        kapiAc();
        bekle();
        if (!kapaliMi())
            kapiKapa();
    }

    public void zilCal() {

    }

    public void bekle() {

    }

    public boolean kapaliMi() {
        return true;
    }

    public void asansorKatGoster(int katNumarasi) {
        System.out.println(katNumarasi);
    }

    public int getKapasite() {
        return kapasite;
    }

    public int getKonumKat() {
        return konumKat;
    }

    public void setKonumKat(int konumKat) {
        this.konumKat = konumKat;
    }

    public int getSüre() {
        return süre;
    }

    public void setSüre(int süre) {
        this.süre = süre;
    }

    public boolean isKilitle() {
        return kilitle;
    }

    public void setKilitle(boolean kilitle) {
        this.kilitle = kilitle;
    }
}
