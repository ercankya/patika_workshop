import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HavaAlani {
    @Id
    @GeneratedValue(generator = "idGenerator", strategy = GenerationType.AUTO)
    private long Id;
    private String havaAlaniAdi;
    private String havaAlaniSehir;

    public HavaAlani() {
    }

    public HavaAlani(String havaAlaniAdi, String havaAlaniSehir) {
        this.havaAlaniAdi = havaAlaniAdi;
        this.havaAlaniSehir = havaAlaniSehir;
    }

    public long getId() {
        return Id;
    }

    public String getHavaAlaniAdi() {
        return havaAlaniAdi;
    }

    public void setHavaAlaniAdi(String havaAlaniAdi) {
        this.havaAlaniAdi = havaAlaniAdi;
    }

    public String getHavaAlaniSehir() {
        return havaAlaniSehir;
    }

    public void setHavaAlaniSehir(String havaAlaniSehir) {
        this.havaAlaniSehir = havaAlaniSehir;
    }
}
