import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HavaYoluSirketi {
    @Id
    @GeneratedValue(generator = "idGenerator", strategy = GenerationType.AUTO)
    private long Id;
    private Ucak ucak;
    private String name;

    public HavaYoluSirketi() {
    }

    public HavaYoluSirketi(Ucak ucak, String name) {
        this.ucak = ucak;
        this.name = name;
    }

    public long getId() {
        return Id;
    }

    public Ucak getUcak() {
        return ucak;
    }

    public void setUcak(Ucak ucak) {
        this.ucak = ucak;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
