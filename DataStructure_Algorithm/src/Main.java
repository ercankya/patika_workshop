import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        //int dizi[] = {22,27,16,2,18,6};
        /** { 2 6 16 18 22 27 } */
        /** 18 avarage case olarak karşılık bulur.*/


        int dizi[] = {7,3,5,8,2,9,4,15,6};
        /** { 2 3 4 5 6 7 8 9 15 } */
        /** 18 avarage case olarak karşılık bulur.*/

        Main m = new Main();
        m.diz(dizi);
        yazdir(dizi);
    }

    void diz(int dizi[]) {
        int n = dizi.length;
        for (int i = 1; i < n; ++i) {/** zaman karmaşıklığı için ilk dalga 'n' */
            int key = dizi[i];
            int j = i - 1;

            while (j >= 0 && dizi[j] > key) { /**zaman karmaşıklığı için ilk dalga 'n' bunanla beraber karmaşıklık n^2 olur*/
                dizi[j + 1] = dizi[j];
                j = j - 1;
            }
            dizi[j + 1] = key;
        }
    }

    static void yazdir(int dizi[]) {
        int n = dizi.length;
        for (int i = 0; i < n; ++i)
            System.out.print(dizi[i] + " ");

        System.out.println();
    }

}
