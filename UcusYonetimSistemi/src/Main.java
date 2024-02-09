import java.util.Date;

public class Main {
    public static void main(String[] args) {

        HavaAlani kalkis = new HavaAlani("Kocaeli Airport","Kocaeli");
        HavaAlani inis = new HavaAlani("DİY Airport","Diyarbakır");
        Date kalkisZaman = new Date();
        Date inisZaman = new Date("01.02.2023");


        Pilot pilot = new Pilot("master","Kenan Komutan");
        YardimciPilot pilot2 = new YardimciPilot("mid-Level","SudeSu");
        Ucak ucak = new Ucak("Boing","TK700",15,pilot,pilot2);
        HavaYoluSirketi havaYoluSirketi = new HavaYoluSirketi(ucak,"Pegasus");
        Ucus ucus = new Ucus(kalkisZaman,inisZaman,kalkis,inis,havaYoluSirketi);


    }
}
