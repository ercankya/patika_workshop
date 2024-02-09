import java.util.Date;
import javax.persistence.*;
@Entity
public class Ucus {
    @Id
    @GeneratedValue(generator = "idGenerator", strategy = GenerationType.AUTO)
    private long Id;
    private Date kalkisZamani;
    private Date InisZamani;
    private HavaAlani KalkisYeri;
    private HavaAlani InisYeri;
    private HavaYoluSirketi havaYoluSirketi;

    public void flying() {

    }

    public Ucus(Date kalkisZamani, Date inisZamani, HavaAlani kalkisYeri, HavaAlani inisYeri,HavaYoluSirketi havaYoluSirketi) {
        this.kalkisZamani = kalkisZamani;
        InisZamani = inisZamani;
        KalkisYeri = kalkisYeri;
        InisYeri = inisYeri;
        havaYoluSirketi = havaYoluSirketi;
    }

    public long getId() {
        return Id;
    }

    public Date getKalkisZamani() {
        return kalkisZamani;
    }

    public void setKalkisZamani(Date kalkisZamani) {
        this.kalkisZamani = kalkisZamani;
    }

    public Date getInisZamani() {
        return InisZamani;
    }

    public void setInisZamani(Date inisZamani) {
        InisZamani = inisZamani;
    }

    public HavaAlani getKalkisYeri() {
        return KalkisYeri;
    }

    public void setKalkisYeri(HavaAlani kalkisYeri) {
        KalkisYeri = kalkisYeri;
    }

    public HavaAlani getInisYeri() {
        return InisYeri;
    }

    public void setInisYeri(HavaAlani inisYeri) {
        InisYeri = inisYeri;
    }
}
