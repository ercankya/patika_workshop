import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ucak {
    @Id
    @GeneratedValue(generator = "idGenerator", strategy = GenerationType.AUTO)
    private int Id;
    private String type;
    private String name;
    private long useTime;

    private Pilot pilot;
    private YardimciPilot yardimciPilot;

    public boolean IsReadyForFly(boolean f){
        return f;
    }

    public Ucak() {
    }

    public Ucak(String type, String name, long useTime, Pilot pilot, YardimciPilot yardimciPilot) {
        this.type = type;
        this.name = name;
        this.useTime = useTime;
        this.pilot = pilot;
        this.yardimciPilot = yardimciPilot;
    }

    public int getId() {
        return Id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUseTime() {
        return useTime;
    }

    public void setUseTime(long useTime) {
        this.useTime = useTime;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public YardimciPilot getYardimciPilot() {
        return yardimciPilot;
    }

    public void setYardimciPilot(YardimciPilot yardimciPilot) {
        this.yardimciPilot = yardimciPilot;
    }
}
