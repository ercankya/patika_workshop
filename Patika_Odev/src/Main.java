import java.text.DecimalFormat;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    Scanner scanner = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String args[]) {
        Main m = new Main();
        m.palindromBulma();
    }
    public void palindromBulma(){
        System.out.println("Metin Girin :");
        String str = scanner.next();
        if (isPalindrom(str)) {
            System.out.println("Palindromdur");
        } else {
            System.out.println("Palindrom değildir.");
        }
    }
    public boolean isPalindrom(String str){
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public void tahminEtOyunu() {
        Random rand = new Random();
        int number = rand.nextInt(100);

        int wrng = 0;
        int selected;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;


        while (wrng < 5) {
            System.out.print("Lütfen tahmininizi giriniz : ");
            selected = scanner.nextInt();

            if (selected < 0 || selected > 99) {
                System.out.println("Lütfen 0-100 arasında bir değer giriniz.");
                if (isWrong) {
                    wrng++;
                    System.out.println("Çok fazla hatalı giriş yaptınız. Kalan hak : " + (5 - wrng));
                } else {
                    isWrong = true;
                    System.out.println("Bir daha hatalı girişinizde hakkınızdan düşülecektir.");
                }
                continue;
            }

            if (selected == number) {
                System.out.println("Tebrikler, doğru tahmin ! Tahmin ettiğini sayı : " + number);
                isWin = true;
                break;
            } else {
                System.out.println("Hatalı bir sayı girdiniz !");
                if (selected > number) {
                    System.out.println(selected + " sayısı, gizli sayıdan büyüktür.");
                } else {
                    System.out.println(selected + " sayısı, gizli sayıdan küçüktür.");
                }

                wrong[wrng++] = selected;
                System.out.println("Kalan hakkı : " + (5 - wrng));
            }
        }

        if (!isWin) {
            System.out.println("Kaybettiniz ! ");
            if (!isWrong) {
                System.out.println("Tahminleriniz : " + Arrays.toString(wrong));
            }
        }

        System.out.print("Sayı = ");
        System.out.println(number);
    }

    public void transposeOfMatris() {
        int row, col;

        System.out.print("Enter the number of row: ");
        row = scanner.nextInt();
        System.out.print("Enter the number of column: ");
        col = scanner.nextInt();


        int[][] arr = new int[row][col];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("Matrix [" + (i + 1) + "]" + "[" + (j + 1) + "]" + " : ");
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Matrix: ");
        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        int[][] transpose = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                transpose[j][i] = arr[i][j];
            }
        }
        System.out.println("Transpose: ");
        for (int[] i : transpose) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

    public void findFrequen() {
        int[] list = {10, 20, 20, 10, 10, 20, 5, 20};
        int[] duplicate = new int[list.length];
        int k = 0;
        int count = 0;
        System.out.println("Mode of Numbers");
        for (int i = 0; i < list.length; i++) {
            count = 0;
            for (int j = 0; j < list.length; j++) {
                if ((i != j) && (list[i] == list[j])) {
                    count++;
                }
            }
            if (isFind(duplicate, list[i])) {
                System.out.println(list[i] + " sayisi " + (count + 1) + " kere tekrar etti.");
                duplicate[k++] = list[i];
            }
        }
    }

    public boolean isFind(int[] duplicate, int value) {
        for (int val : duplicate) {
            if (val == value) {
                return false;
            }
        }
        return true;
    }

    public void sortNum() {
        System.out.println("Enter array size :");
        int byt = scanner.nextInt();
        int[] nums = new int[byt];
        while (byt > 0) {
            System.out.println("Enter Array element :");
            nums[byt - 1] = scanner.nextInt();
            byt--;
        }
        System.out.println("Unsorted list: " + Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println("Sorted list: " + Arrays.toString(nums));
    }

    public void dublicatedNum() {
        int[] list = {3, 7, 3, 3, 10, 9, 10, 21, 1, 33, 9, 1};
        int[] duplicate = new int[list.length];
        int[] duplicateEven = new int[list.length];
        int index = 0, indexEven = 0;

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if ((i != j) && (list[i] == list[j])) {
                    if (list[i] % 2 == 0) {
                        duplicateEven[indexEven] = list[i];
                        indexEven++;
                    }
                    duplicate[index] = list[i];
                    index++;
                    break;
                }
            }
        }
        System.out.println("Duplicate list: " + Arrays.toString(duplicate));
        System.out.println("Even duplicate list: " + Arrays.toString(duplicateEven));
    }

    public void printStars() {
        String[][] letter = new String[7][4];

        for (int i = 0; i < letter.length; i++) {
            for (int j = 0; j < letter[i].length; j++) {
                if (i == 0 || i == 3 || i == 6) {
                    letter[i][j] = " * ";
                } else if (j == 0 || j == 3) {
                    letter[i][j] = " * ";
                } else {
                    letter[i][j] = "   ";
                }
            }
        }

        for (String[] row : letter) {
            for (String col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public void maxMin() {
        int[] list = {56, 34, 1, 8, 101, -2, -33};

        int min = list[0];
        int max = list[0];
        for (int s : list) {
            if (min > s) {
                min = s;
            }
            if (max < s) {
                max = s;
            }
        }
        System.out.println("Min :" + min);
        System.out.println("Max :" + max);
    }

    public void fraktalDesen() {
        System.out.println("N Sayısı : ");
        int frktl = scanner.nextInt();
        recFraktal(frktl);
    }

    public void recFraktal(int frktl) {
        if (frktl > 0) {
            System.out.print(frktl + " ");
            recFraktal(frktl - 5);
        }
        System.out.print(frktl + " ");
    }

    public void asalKontrol() {
        System.out.println("Sayı Giriniz : ");
        int asal = scanner.nextInt();
        if (asalKontroll(asal, 2))
            System.out.println(asal + " asaldır.");
        else
            System.out.println(asal + " asal değildir.");
    }

    public boolean asalKontroll(int asal, int flg) {
        if (asal <= 2)
            return asal == 2;
        if (asal % flg == 0)
            return false;
        if (flg * flg > asal) {
            return true;
        }
        return asalKontroll(asal, flg + 1);
    }

    public void usluSayiHesaplama() {
        System.out.println("Taban değeri giriniz :");
        int tbn = scanner.nextInt();
        System.out.println("Üs değerini giriniz :");
        int us = scanner.nextInt();
        if (us < 0)
            System.out.println("Hatalı giriş");
        System.out.println("Sonuç : " + recursiveUsluSayiHesaplama(tbn, us + 1));
    }

    public int recursiveUsluSayiHesaplama(int tbn, int us) {
        if (tbn == 1 || us == 0)
            return 1;
        if (tbn == 0)
            return 0;
        if (us == 1)
            return tbn;
        return recursiveUsluSayiHesaplama(tbn, us - 2) * recursiveUsluSayiHesaplama(tbn, us - 1);
    }

    public void gelismisHesapMakinesi() {
        int select;
        String menu = "1- Toplama İşlemi\n"
                + "2- Çıkarma İşlemi\n"
                + "3- Çarpma İşlemi\n"
                + "4- Bölme işlemi\n"
                + "5- Üslü Sayı Hesaplama\n"
                + "6- Faktoriyel Hesaplama\n"
                + "7- Mod Alma\n"
                + "8- Dikdörtgen Alan ve Çevre Hesabı\n"
                + "0- Çıkış Yap";

        do {
            System.out.println(menu);
            System.out.print("Lütfen bir işlem seçiniz :");
            select = scanner.nextInt();
            switch (select) {
                case 1:
                    plus();
                    break;
                case 2:
                    minus();
                    break;
                case 3:
                    times();
                    break;
                case 4:
                    divided();
                    break;
                case 5:
                    power();
                    break;
                case 6:
                    factorial();
                    break;
                case 7:
                    mode();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Yanlış bir değer girdiniz, tekrar deneyiniz.");
            }
        } while (select != 0);
    }

    public void palindrom() {
        System.out.println("Sayı Giriniz :");
        int n = scanner.nextInt();
        int tmp = n, last, reverse = 0;
        while (tmp != 0) {
            last = tmp % 10;
            reverse = reverse * 10 + last;
            tmp /= 10;
        }
        if (reverse == n) {
            System.out.println("Palindrom");
        } else {
            System.out.println("Palindrom değildir.");
        }
    }

    public void palindromStr() {
        System.out.println("String Giriniz :");
        String n = scanner.next();
        String arr[] = n.split("");
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr.length % 2 != 0 && i == arr.length / 2 + 1) break;
            if (!arr[i].equals(arr[arr.length - i - 1])) {
                flag = false;
                break;
            } else
                flag = true;
        }
        if (!flag)
            System.out.println("Palindrom değildir.");
        else
            System.out.println("Palindrom");
    }

    public void seriHesaplama() {
        System.out.println("Sayı Giriniz :");
        int nmbr = scanner.nextInt();
        int a, b, n;
        for (int i = 0; i < nmbr; i++) {
            System.out.println("A Sayısını Giriniz :");
            a = scanner.nextInt();
            System.out.println("B Sayısını Giriniz :");
            b = scanner.nextInt();
            System.out.println("N Sayısını Giriniz :");
            n = scanner.nextInt();
            int topl = 0;
            for (int j = 0; j < n; j++) {
                topl += (int) (Math.pow(2, j) * b);
                System.out.print(a + topl);
                System.out.println();
            }
            System.out.println();
        }
    }

    public void fibonaci() {
        System.out.println("Sayı Giriniz :");
        int n = scanner.nextInt();
        int a1 = 0, a2 = 1;
        System.out.println(1);
        for (int i = 1; i <= n / 2; i++) {
            a1 = a1 + a2;
            System.out.println(a1);
            a2 = a2 + a1;
            System.out.println(a2);
        }
    }

    public int fibonaci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonaci(n - 1) + fibonaci(n - 2);
    }

    public void asalSayilar() {
        System.out.println("Sayı Giriniz :");
        int n = scanner.nextInt();

        for (int i = 2; i <= n; i++) {
            int sayac = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    sayac++;
                }
            }
            if (sayac == 0) {
                System.out.println(i);
            }
        }
    }

    public void tersUcgen() {
        System.out.println("Bir Sayı Giriniz :");
        int n = scanner.nextInt();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = (n - i); j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = (2 * i + 1); k > 0; k--) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }

    public void mukemmelSayi() {
        System.out.println("Bir Sayı Giriniz :");
        int a = scanner.nextInt();
        int b = 0;

        for (int i = 1; i < a; i++) {
            if (a % i == 0) {
                b += i;
            }
        }
        if (b == a) {
            System.out.print(a + " mükemmel sayıdır.\n");
        } else {
            System.out.print(a + " mükemmel sayı değildir.\n");
        }
    }

    public void minMaxBulma() {
        int n2;
        int max = 0, min = 0;
        do {
            System.out.println("Sayı Giriniz :");
            n2 = scanner.nextInt();
            if (max == 0) {
                min = n2;
                max = n2;
            }
            if (min > n2 && n2 > 0) {
                min = n2;
            }
            if (max < n2) {
                max = n2;
            }
        } while (n2 > 0);
        System.out.println("Max sayı : " + max);
        System.out.println("Min sayı : " + min);
    }

    public void ebobekok() {
        System.out.println("Birinci Sayıyı Giriniz :");
        int n = scanner.nextInt();
        System.out.println("Ikinci Sayıyı Giriniz :");
        int n2 = scanner.nextInt();
        int ebob = 0;


/*        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && n2 % i == 0) {
                ebob = i;
            }
        }*/
        int i = 1;
        while (i <= n) {
            if (n % i == 0 && n2 % i == 0) {
                ebob = i;
            }
            i++;
        }
        System.out.println("EBOB : " + ebob);
        System.out.println("EKOK : " + (n * n2) / ebob);
    }

    public void atmProje() {
        String userName, password;
        int right = 3;
        int balance = 1500;
        int select;
        while (right > 0) {
            System.out.print("Kullanıcı Adınız :");
            userName = scanner.nextLine();
            System.out.print("Parolanız : ");
            password = scanner.nextLine();
            if (userName.equals("ercan") && password.equals("123")) {
                System.out.println("Merhaba, Kodluyoruz Bankasına Hoşgeldiniz!");
                do {
                    System.out.println("1-Para yatırma\n" +
                            "2-Para Çekme\n" +
                            "3-Bakiye Sorgula\n" +
                            "4-Çıkış Yap");
                    System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz : ");
                    select = scanner.nextInt();

                    switch (select) {
                        case 1:
                            System.out.print("Para miktarı : ");
                            int price = scanner.nextInt();
                            balance += price;
                            break;
                        case 2:
                            System.out.print("Para miktarı : ");
                            price = scanner.nextInt();
                            if (price > balance) {
                                System.out.println("Bakiye yetersiz.");
                            } else {
                                balance -= price;
                            }
                            break;
                        case 3:
                            System.out.println("Bakiyeniz : " + balance);
                            break;
                        case 4:
                            System.out.println("Tekrar görüşmek üzere.");
                            break;
                        default:
                            System.out.println("Hatalı Giriş");
                            break;
                    }
                    /*
                    if (select == 1) {
                        System.out.print("Para miktarı : ");
                        int price = scanner.nextInt();
                        balance += price;
                    } else if (select == 2) {
                        System.out.print("Para miktarı : ");
                        int price = scanner.nextInt();
                        if (price > balance) {
                            System.out.println("Bakiye yetersiz.");
                        } else {
                            balance -= price;
                        }
                    } else if (select == 3) {
                        System.out.println("Bakiyeniz : " + balance);
                    }*/
                } while (select != 4);
                break;
            } else {
                right--;
                System.out.println("Hatalı kullanıcı adı veya şifre. Tekrar deneyiniz.");
                if (right == 0) {
                    System.out.println("Hesabınız bloke olmuştur lütfen banka ile iletişime geçiniz.");
                } else {
                    System.out.println("Kalan Hakkınız : " + right);
                }
            }
        }
    }

    public void ucgenYildiz() {
        System.out.println("Bir Sayı Giriniz :");
        int n = scanner.nextInt();

        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < (n - i); j++) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= (2 * i + 1); k++) {
                    System.out.print("*");
                }
                System.out.println(" ");
            }
            for (int i = n / 2 - 1; i >= 0; i--) {
                for (int j = (n - i); j > 0; j--) {
                    System.out.print(" ");
                }
                for (int k = (2 * i + 1); k > 0; k--) {
                    System.out.print("*");
                }
                System.out.println(" ");
            }
        } else {
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < (n - i); j++) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= (2 * i + 1); k++) {
                    System.out.print("*");
                }
                System.out.println(" ");
            }
            for (int i = n / 2; i >= 0; i--) {
                for (int j = (n - i); j > 0; j--) {
                    System.out.print(" ");
                }
                for (int k = (2 * i + 1); k > 0; k--) {
                    System.out.print("*");
                }
                System.out.println(" ");
            }
        }
    }

    public void harmonikSeri() {
        System.out.println("Sayı Giriniz :");
        int sayi = scanner.nextInt();
        double htopl = 0.0;
        while (sayi > 0) {
            htopl += (1.0 / sayi);
            sayi--;
        }
        System.out.println(htopl);
    }

    public void harmonikOrt() {
        System.out.println("2, 3, 7, 3, 9 ");
        int[] sayi = {2, 3, 7, 3, 9};
        double htopl = 0.0;
        for (int s : sayi) {
            htopl += (1.0 / s);
        }
        System.out.println(htopl);
    }

    public void armstrongBulma() {
        System.out.println("Sayı Giriniz :");
        int sayi = scanner.nextInt();
        int baseNmber = sayi;
        String strSayi = sayi + "";

        while (baseNmber > 0) {
            int topl = 0;
            sayi = baseNmber;
            while (sayi > 0) {
                topl += Math.pow((sayi % 10), strSayi.length());
                sayi /= 10;
            }

            if (topl == baseNmber) {
                System.out.println(baseNmber + " sayısı bir Armstrong sayıdır.");
            } else
                System.out.println(baseNmber + " sayısı bir Armstrong sayısı değildir.");

            baseNmber--;
        }
    }

    public void armstrong2Bulma() {
        System.out.println("Sayı Giriniz :");
        int sayi = scanner.nextInt();
        int baseNmber = sayi;
        String strSayi = sayi + "";
        int topl = 0;

        while (sayi > 0) {
            topl += Math.pow((sayi % 10), strSayi.length());
            sayi /= 10;
        }

        if (topl == baseNmber) {
            System.out.println(baseNmber + " sayısı bir Armstrong sayıdır.");
        } else
            System.out.println(baseNmber + " sayısı bir Armstrong sayısı değildir.");
    }

    public void basamaklarToplami() {
        System.out.println("Sayı Giriniz :");
        int sayi = scanner.nextInt();
        int topl = 0;

        while (sayi > 0) {
            topl += (sayi % 10);
            sayi = sayi / 10;
        }
        System.out.println("Basamaklar Toplamı :" + topl);
    }

    public void kuvvetSayiHesaplama() {
        System.out.println("Sayı Giriniz :");
        int sayi = scanner.nextInt();
        System.out.println("Üs Değeri Giriniz :");
        int us = scanner.nextInt();
        int topl = 1;
        int i = 1;
        while (i <= us) {
            topl *= sayi;
            i++;
        }
        System.out.println("Girilen üslü sayının değeri :" + topl);
        topl = sayi;
        for (int j = 0; j < us; j++) {
            topl *= sayi;
        }
        System.out.println("Girilen üslü sayının değeri :" + topl);

    }

    public void faktoriyelHesaplama() {
        System.out.println("Sayı Giriniz :");
        int sayi = scanner.nextInt();
        int faktoryl = 1;
        for (int i = 1; i <= sayi; i++) {
            faktoryl *= i;
        }
        System.out.println(sayi + "Faktöriyel : " + faktoryl);
    }

    public int faktoriyel(int sayi) {
        int faktoryl = 1;
        for (int i = 1; i <= sayi; i++) {
            faktoryl *= i;
        }
        return faktoryl;
    }

    public void kombinasyonHesaplama() {
        System.out.println("Eleman Sayısı Giriniz :");
        int n = scanner.nextInt();
        int r;
        do {
            System.out.println("Gruplama Sayısı Giriniz :");
            r = scanner.nextInt();
        } while (n < r);
        int sonuc = faktoriyel(n) / (faktoriyel(r) * faktoriyel(n - r));
        System.out.println(" N’in r’li kombinasyonu : " + sonuc);
    }

    public void sayiKuvvetBulma() {
        System.out.println("Sayı Giriniz :");
        int sayi = scanner.nextInt();

        System.out.println("2 nin kuvvetleri");
        for (int i = 1; i < sayi; i *= 2) {
            System.out.println(i);
        }
        System.out.println("4 ve 5 in kuvvetleri");
        for (int i = 1; i < sayi; i *= 20) {
            System.out.println(i);
        }

    }

    public void tekSayiBulma() {

        int n = 0;
        int topl = 0;
        do {
            System.out.println("Sayı Giriniz : ");
            n = scanner.nextInt();
            if (n % 2 == 1) {
                topl += n;
            }
        } while (n > 0);
        System.out.println("Tek Sayıların Toplam :" + topl);
        topl = 0;
        do {
            System.out.println("Sayı Giriniz : ");
            n = scanner.nextInt();
            if (n % 4 == 0) {
                topl += n;
            }
        } while (n % 2 != 1);
        System.out.println("4 Katları olan Sayıların Toplam :" + topl);

    }

    public void ciftSayiBulma() {
        System.out.println("Sayı Giriniz :");
        int sayi = scanner.nextInt();

        for (int i = 0; i < sayi; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " ");
            }
        }

        int topl = 0, count = 0;
        for (int j = 1; j < sayi; j++) {
            if (j % 3 == 0 && j % 4 == 0) {
                topl += j;
                count++;
            }
        }
        System.out.println("12'ye bölenen sayıların ortalaması = " + topl / count);
    }

    public void artikYilBulma() {
        System.out.println("Yıl Giriniz :");
        int artikYil = scanner.nextInt();
        boolean flag = false;

        if (artikYil % 4 == 0) {
            if (artikYil % 100 == 0) {
                if (artikYil % 400 == 0) {
                    flag = true;
                }
            } else {
                flag = true;
            }
        }

        if (flag) {
            System.out.println(artikYil + " Yılı Bir Artık Yıldır !");
            return;
        }
        System.out.println(artikYil + " Yılı Bir Artık Yıl Değildir !");
    }

    public void sicakligaGoreEtkinlikBulma() {
        double sicaklik;
        System.out.println("Sıcaklığı Giriniz : ");
        sicaklik = scanner.nextDouble();

        if (sicaklik < 5) {
            System.out.println("Kayak Yapabilirsiniz .");
        } else if (5 < sicaklik && sicaklik < 15) {
            System.out.println("Sinemaya Gidebilirsiniz .");
        } else if (15 < sicaklik && sicaklik < 25) {
            System.out.println("Piknige Gidebilirsiniz .");
        } else if (sicaklik > 25) {
            System.out.println("Yuzmeye Gidebilirsiniz .");
        } else
            System.out.println("Geçersiz Etkinlik.");
    }

    public void burcBulma() {
        int mont, day;

        System.out.println("Doğduğunuz Ayı Girin :");
        mont = scanner.nextInt();

        System.out.println("Doğduğunuz Günü Girin :");
        day = scanner.nextInt();

        if (mont > 0 && 12 > mont && day <= 31 && day > 0) {
            if (mont == 1) {
                if (day <= 21) {
                    System.out.println("Oğlak");
                } else {
                    System.out.println("Kova");
                }
            } else if (mont == 2) {
                if (day <= 19) {
                    System.out.println("Kova");
                } else {
                    System.out.println("Balık");
                }
            } else if (mont == 3) {
                if (day <= 20) {
                    System.out.println("Balık");
                } else {
                    System.out.println("Koç");
                }
            } else if (mont == 4) {
                if (day <= 20) {
                    System.out.println("Koç");
                } else {
                    System.out.println("Boğa");
                }
            } else if (mont == 5) {
                if (day <= 21) {
                    System.out.println("Boğa");
                } else {
                    System.out.println("Ikizler");
                }
            } else if (mont == 6) {
                if (day <= 22) {
                    System.out.println("Ikizler");
                } else {
                    System.out.println("Yengeç");
                }
            } else if (mont == 7) {
                if (day <= 22) {
                    System.out.println("Yengeç");
                } else {
                    System.out.println("Aslan");
                }
            } else if (mont == 8) {
                if (day <= 22) {
                    System.out.println("Aslan");
                } else {
                    System.out.println("Başak");
                }
            } else if (mont == 9) {
                if (day <= 22) {
                    System.out.println("Başak");
                } else {
                    System.out.println("Terazi");
                }
            } else if (mont == 10) {
                if (day <= 22) {
                    System.out.println("Terazi");
                } else {
                    System.out.println("Akrep");
                }
            } else if (mont == 11) {
                if (day <= 21) {
                    System.out.println("Akrep");
                } else {
                    System.out.println("Yay");
                }
            } else if (mont == 12) {
                if (day <= 21) {
                    System.out.println("Yay");
                } else {
                    System.out.println("Oğlak");
                }
            }
        } else
            System.out.println("Hatalı Giriş, Doğduğunuz ayı ve günü sayısal olarak girin");
    }

    public void daireAlanBulma() {
        final double pi = 3.14;
        double alan;
        double dilimAlan;
        double cevre;
        double yaricap;
        double merkezAci;

        System.out.println("Dairenin yarıçapını girin : ");
        yaricap = scanner.nextDouble();
        alan = pi * Math.pow(yaricap, 2);
        cevre = 2 * pi * yaricap;

        System.out.println("Dairenin alanı : " + alan);
        System.out.println("Dairenin Çevresi : " + cevre);

        System.out.println("2. Dairenin yarıçapını girin : ");
        yaricap = scanner.nextDouble();

        System.out.println("2. Daire diliminin merkez açısını girin : ");
        merkezAci = scanner.nextDouble();
        dilimAlan = (pi * Math.pow(yaricap, 2) * merkezAci) / 360;
        System.out.println("2. Daire diliminin Alanı : " + dilimAlan);

    }

    public void kitleIndeksBulma() {
        double boy;
        double kilo;
        double bmi;

        System.out.println("Boyunuzu metre cinsinden girin : ");
        boy = scanner.nextDouble();

        System.out.println("Kilonuzu kg cinsinden girin : ");
        kilo = scanner.nextDouble();

        bmi = kilo / Math.pow(boy, 2);
        System.out.println("Vücut Kitle Indeksiniz : " + bmi);

    }

    public void dersNotuHesaplama() {
        HashMap<String, Integer> dersler = new HashMap<String, Integer>();
        double ortalama = 0;

        dersler.put("Matematik", 0);
        dersler.put("Fizik", 0);
        dersler.put("Türkçe", 0);
        dersler.put("Kimya", 0);
        dersler.put("Müzik", 0);


        for (String a : dersler.keySet()) {
            System.out.println(a + " Notunu girin :");
            int b = scanner.nextInt();
            if (b >= 0 && b <= 100) {
                dersler.replace(a, b);
                ortalama += b;
            }
        }

        System.out.println(dersler);
        System.out.println("Derslerin Ortalaması : " + ortalama / dersler.size());
        if ((ortalama / dersler.size()) >= 55) {
            System.out.println("Geçti");
        } else
            System.out.println("Kaldı");

    }

    public void hipotenusBulma() {

        Double kenar1, kenar2, kenar3, kenar4, kenar5, kenar6 = 0.0;
        Double ucgencevresi = 0.0;
        Double ucgenalan = 0.0;

        System.out.println("Üçgenin kenar uzunluklarını girin : ");
        kenar1 = scanner.nextDouble();
        kenar2 = scanner.nextDouble();
        kenar3 = scanner.nextDouble();
        ucgencevresi = (kenar1 + kenar2 + kenar3) / 2;/**x2*/
        ucgenalan = ucgencevresi * (ucgencevresi - kenar1) * (ucgencevresi - kenar2) * (ucgencevresi - kenar3);

        System.out.println("Üçgenin Alanı : " + Math.sqrt(ucgenalan));
        System.out.println("Hipotenüs bulmak için iki kenar girin : ");
        kenar4 = scanner.nextDouble();
        kenar5 = scanner.nextDouble();
        kenar6 = Math.sqrt(Math.pow(kenar4, 2) + Math.pow(kenar5, 2));

        System.out.println("Hipotenüs : " + kenar6);
    }

    public void kdvHesaplama() {
        int kdv = 18;
        Double netMiktar, kdvMiktar = 0.0;

        System.out.println("Miktarı Girin : ");
        netMiktar = scanner.nextDouble();
        if (netMiktar > 1000.0) {
            kdv = 8;
        }
        kdvMiktar = (netMiktar * kdv) / 100;
        System.out.println("Kdv'siz Tutar : " + netMiktar);
        System.out.println("Kdv'li Tutar : " + (netMiktar + kdvMiktar));
        System.out.println("KDV Tutarı: " + kdvMiktar);
    }

    public void taksimetre() {
        int km;
        double perKm = 2.20;
        double initial = 10.0;
        double total;

        System.out.println("Gidilen Yolu km cinsinden yazın : ");
        km = scanner.nextInt();
        total = km * perKm + initial;
        total = total > 20 ? total : 20;
        System.out.println("Ücret : " + Math.ceil(total)); // yuvarlama işlemi eklendi.
    }

    public void dortIslem() {
        int nmber1, nmber2, islem;

        System.out.println("Ilk sayıyı girin : ");
        nmber1 = scanner.nextInt();

        System.out.println("Ikinci sayıyı girin : ");
        nmber2 = scanner.nextInt();

        System.out.println("1.Toplama \n2.Çıkarma \n3.Çarpma \n4.Bölme \n ");
        System.out.println("Islem numarasını girin  : ");
        islem = scanner.nextInt();

        System.out.println("if-else bloğu");
        if (islem == 1) {
            System.out.println("Toplama Sonucu  : " + (nmber1 + nmber2));
        } else if (islem == 2) {
            System.out.println("Çıkarma Sonucu  : " + (nmber1 - nmber2));
        } else if (islem == 3) {
            System.out.println("Çarpma Sonucu  : " + (nmber1 * nmber2));
        } else if (islem == 4) {
            System.out.println("Bölme Sonucu  : " + (nmber1 / nmber2));
        } else {
            System.out.println("Tanımsız Islem Seçtiniz!");
        }

        System.out.println("switch-case bloğu");
        switch (islem) {
            case 1:
                System.out.println("Toplama Sonucu  : " + (nmber1 + nmber2));
                break;
            case 2:
                System.out.println("Çıkarma Sonucu  : " + (nmber1 - nmber2));
                break;
            case 3:
                System.out.println("Çarpma Sonucu  : " + (nmber1 * nmber2));
                break;
            case 4:
                System.out.println("Bölme Sonucu  : " + (nmber1 / nmber2));
                break;
            default:
                System.out.println("Tanımsız Islem Seçtiniz!");
        }
    }

    public void decimalTipeGoreBouyut() {
        List<Long> nmber = new ArrayList<>();
        List<String> other = new ArrayList<>();

        System.out.println("Girilecek Sayı adetini girin : ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            try {
                nmber.add(scanner.nextLong());
            } catch (Exception e) {
                other.add(scanner.next());
            }
        }
        for (int i = 0; i < nmber.size(); i++) {
            System.out.println(nmber.get(i) + " sayısı şu tipler kapsamına girer :");
            if (nmber.get(i) >= Byte.MIN_VALUE && nmber.get(i) <= Byte.MAX_VALUE) {
                System.out.println("* byte");
            }
            if (nmber.get(i) >= Short.MIN_VALUE && nmber.get(i) <= Short.MAX_VALUE) {
                System.out.println("* short");
            }
            if (nmber.get(i) >= Integer.MIN_VALUE && nmber.get(i) <= Integer.MAX_VALUE) {
                System.out.println("* integer");
            }
            if (nmber.get(i) >= Long.MIN_VALUE && nmber.get(i) <= Long.MAX_VALUE) {
                System.out.println("* long");
            }
        }
        for (int j = 0; j > other.size(); j++) {
            if (other.get(j) != null && other.get(j) != "") {
                System.out.println(other.get(j) + " sayısı şu tipler kapsamına girer :");
                System.out.println(" Hiçbir tip bu değeri kapsamaz.");
            }
        }
    }

    public void cinZodyagiBurcBulma() {
        System.out.println("Doğum Yılınızı giriniz :");
        int dogumYili = scanner.nextInt();

        if (dogumYili % 12 == 1) {
            System.out.println("Horoz");
        } else if (dogumYili % 12 == 2) {
            System.out.println("Köpek");

        } else if (dogumYili % 12 == 3) {
            System.out.println("Domuz");

        } else if (dogumYili % 12 == 4) {
            System.out.println("Fare");

        } else if (dogumYili % 12 == 5) {
            System.out.println("Öküz");

        } else if (dogumYili % 12 == 6) {
            System.out.println("Kaplan");

        } else if (dogumYili % 12 == 7) {
            System.out.println("Tavşan");

        } else if (dogumYili % 12 == 8) {
            System.out.println("Ejdarha");

        } else if (dogumYili % 12 == 9) {
            System.out.println("Yılan");

        } else if (dogumYili % 12 == 10) {
            System.out.println("At");

        } else if (dogumYili % 12 == 11) {
            System.out.println("Koyun");

        } else if (dogumYili % 12 == 0) {
            System.out.println("Maymun");

        } else {
            System.out.println("Geçersiz değer girdiniz.");
        }
    }

    public void ucakbiletFiyatHesaplama() {
        int yas, mesafe, yolculukTipi;
        double tplmTutar, indirimliTutar;

        System.out.println("Yaşınızı giriniz :");
        yas = scanner.nextInt();

        System.out.println("Mesafeyi km türünden giriniz :");
        mesafe = scanner.nextInt();

        System.out.println("Yolculuk tipini giriniz (1 => Tek Yön , 2 => Gidiş Dönüş):");
        yolculukTipi = scanner.nextInt();

        if ((yolculukTipi != 1 && yolculukTipi != 2) || (mesafe < 0) || (yas < 0)) {
            System.out.println("Hatalı Veri Girdiniz !");
            return;
        }

        tplmTutar = mesafe * 0.1;
        System.out.println("toplam = " + tplmTutar);

        if (yas < 12) {
            indirimliTutar = tplmTutar - tplmTutar * 0.5;
            System.out.println("12 yaş altı indirimi " + indirimliTutar);
        } else if (yas > 12 && yas < 24) {
            indirimliTutar = tplmTutar - tplmTutar * 0.1;
            System.out.println("12-24 yaş indirimi " + indirimliTutar);

        } else if (yas > 65) {
            indirimliTutar = tplmTutar - tplmTutar * 0.3;
            System.out.println("65 yaş indirimi " + indirimliTutar);

        } else {
            indirimliTutar = tplmTutar;
            System.out.println("indirimsiz " + indirimliTutar);
        }

        if (yolculukTipi == 2) {
            indirimliTutar = (indirimliTutar - indirimliTutar * 0.2) * 2;
            System.out.println("Yolculuk tipi indirimi " + indirimliTutar);
        }

        System.out.println("Toplam Tutar = " + indirimliTutar);
    }

    public void sayiSıralama() {
        int[] arr = new int[3];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Sayıyı Girin");
            arr[i] = scanner.nextInt();
        }

        if (arr[0] > arr[1] && arr[0] > arr[2]) {
            if (arr[1] > arr[2]) {
                System.out.println("a>b>c");
            } else
                System.out.println("a>c>b");
        } else if (arr[1] > arr[0] && arr[1] > arr[2]) {
            if (arr[0] > arr[2]) {
                System.out.println("b>a>c");
            } else
                System.out.println("b>c>a");
        } else {
            if (arr[0] > arr[1]) {
                System.out.println("c>a>b");
            } else
                System.out.println("c>b>a");
        }
    }

    public void meyveSepetiHesaplama() {
        HashMap<String, Double> meyveler = new HashMap<String, Double>();
        meyveler.put("Armut", 2.14);
        meyveler.put("Elma", 3.67);
        meyveler.put("Domates", 1.11);
        meyveler.put("Muz", 0.95);
        meyveler.put("Patlıcan", 5.00);

        double tatol = 0.0;
        int kilo;

        for (String i : meyveler.keySet()) {
            System.out.println(i + " Kaç Kilo : ");
            kilo = scanner.nextInt();
            tatol += (kilo * meyveler.get(i));
        }
        System.out.println("Toplam Tutar : " + tatol);
    }

    static void plus() {
        Scanner scan = new Scanner(System.in);
        int number, result = 0, i = 1;
        while (true) {
            System.out.print(i++ + ". sayı :");
            number = scan.nextInt();
            if (number == 0) {
                break;
            }
            result += number;
        }
        System.out.println("Sonuç : " + result);
    }

    static void minus() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Kaç adet sayı gireceksiniz :");
        int counter = scan.nextInt();
        int number, result = 0;

        for (int i = 1; i <= counter; i++) {
            System.out.print(i + ". sayı :");
            number = scan.nextInt();
            if (i == 1) {
                result += number;
                continue;
            }
            result -= number;
        }
        System.out.println("Sonuç : " + result);
    }

    static void times() {
        Scanner scan = new Scanner(System.in);
        int number, result = 1, i = 1;

        while (true) {
            System.out.print(i++ + ". sayı :");
            number = scan.nextInt();

            if (number == 1)
                break;

            if (number == 0) {
                result = 0;
                break;
            }
            result *= number;
        }
        System.out.println("Sonuç : " + result);
    }

    static void divided() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Kaç adet sayı gireceksiniz :");
        int counter = scan.nextInt();
        double number, result = 0.0;

        for (int i = 1; i <= counter; i++) {
            System.out.print(i + ". sayı :");
            number = scan.nextDouble();
            if (i != 1 && number == 0) {
                System.out.println("Böleni 0 giremezsiniz.");
                continue;
            }
            if (i == 1) {
                result = number;
                continue;
            }
            result /= number;
        }
        System.out.println("Sonuç : " + result);
    }

    static void power() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Taban değeri giriniz :");
        int base = scan.nextInt();
        System.out.print("Üs değeri giriniz :");
        int exponent = scan.nextInt();
        int result = 1;

        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        System.out.println("Sonuç : " + result);
    }

    static void factorial() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Sayı giriniz :");
        int n = scan.nextInt();
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println("Sonuç : " + result);
    }

    static void mode() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Sayı giriniz :");
        int n = scan.nextInt();
        System.out.print("Mode giriniz :");
        int m = scan.nextInt();
        System.out.println("Sonuç : " + n % m);
    }
}

