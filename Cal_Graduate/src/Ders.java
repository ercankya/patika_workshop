import javax.persistence.*;


@Entity
public class Ders {
    @Id
    @GeneratedValue(generator = "idGenerator", strategy = GenerationType.AUTO)
    private Long dersId;
    private String dersAd;
    private Double dersNot;

    public Ders() {
    }

    public Long getDersId() {
        return dersId;
    }

    public void setDersId(Long dersId) {
        this.dersId = dersId;
    }

    public String getDersAd() {
        return dersAd;
    }

    public void setDersAd(String dersAd) {
        this.dersAd = dersAd;
    }

    public Double getDersNot() {
        return dersNot;
    }

    public void setDersNot(Double dersNot) {
        this.dersNot = dersNot;
    }
}
