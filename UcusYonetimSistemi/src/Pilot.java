import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pilot {
    @Id
    @GeneratedValue(generator = "idGenerator", strategy = GenerationType.AUTO)
    private int Id;
    private String deneyimSeviyesi;
    private String name;

    public Pilot(String deneyimSeviyesi, String name) {
        this.deneyimSeviyesi = deneyimSeviyesi;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public String getDeneyimSeviyesi() {
        return deneyimSeviyesi;
    }

    public void setDeneyimSeviyesi(String deneyimSeviyesi) {
        this.deneyimSeviyesi = deneyimSeviyesi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
