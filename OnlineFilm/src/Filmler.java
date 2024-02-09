import javax.persistence.*;

@Entity
public class Filmler {
    @Id
    @GeneratedValue(generator = "idGenerator", strategy = GenerationType.AUTO)
    private int Id;
    private String name;
    private int krediMaliyet;

    public Filmler(String name, int krediMaliyet) {
        this.name = name;
        this.krediMaliyet = krediMaliyet;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKrediMaliyet() {
        return krediMaliyet;
    }

    public void setKrediMaliyet(int krediMaliyet) {
        this.krediMaliyet = krediMaliyet;
    }
}
