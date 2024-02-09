import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.login();
    }
    void login(){
        String oldUserName = "ercankya", oldPass = "13524";
        String userName, pass;
        String flg;

        Scanner sc = new Scanner(System.in);

        System.out.println("Kullanıcı Adınızı Girin : ");
        userName = sc.nextLine();

        System.out.println("Kullanıcı Şifrenizi Girin : ");
        pass = sc.nextLine();

        if (userName.equals(oldUserName) && pass.equals(oldPass)) {
            System.out.println("Giriş yapıldı.");
        } else {
            System.out.println("Giriş Başarısız");
            System.out.println("Şifreyi Sıfırlamak ister misiniz ?  E / H");
            flg = sc.nextLine().toUpperCase();
            if (flg.equals("E")) {
                resetPass(pass);
            }
        }
    }
    void resetPass(String pass){
        Scanner sc = new Scanner(System.in);

        String pass2;
        String oldUserName = "ercankya", oldPass = "13524";

        System.out.println("Yeni Şifrenizi Girin : ");
        pass2 = sc.nextLine();

        if(pass2.equals(pass)){
            System.out.println("Hatalı şifre girilemez");
            resetPass(pass);
        }else if(pass2.equals(oldPass)){
            System.out.println("Eski Şifre Kullanılamaz başka şifre girin");
            resetPass(pass);
        }else
            System.out.println("Şifreniz Sıfırlandı.");
    }
}
