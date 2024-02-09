import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        List<Ders> dersList = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("#.##");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ders Sayısı Girin : ");
        int dersSayisi = scanner.nextInt();
        Double notOrtalam = 0.00d;
        int sayac = dersSayisi;

        while(sayac > 0){
            Ders dersIn = new Ders();
            System.out.println("Ders Adını Girin : ");
            String str = scanner.next();
            dersIn.setDersAd(str);

            System.out.println("Ders Notunu Girin : ");
            Double dbl = scanner.nextDouble();
            dersIn.setDersNot(dbl);

            dersList.add(dersIn);
            sayac--;
        }
        for(Ders dersOut:dersList){
            System.out.println(dersOut.getDersAd() + " Notunuz : " + dersOut.getDersNot());
            notOrtalam += dersOut.getDersNot();
        }
        notOrtalam/=dersSayisi;
        System.out.println("Ortalamanız : " + df.format(notOrtalam));
        System.out.println((notOrtalam)>60? "Sınıfı Geçti" : "Sınıfta Kaldı");
    }
}
