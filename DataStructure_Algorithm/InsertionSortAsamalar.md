Proje 1
[22,27,16,2,18,6] -> Insertion Sort

Yukarı verilen dizinin sort türüne göre aşamalarını yazınız. Big-O gösterimini yazınız. Time Complexity: Average case:
Aradığımız sayının ortada olması,Worst case: Aradığımız sayının sonda olması, Best case: Aradığımız sayının dizinin en
başında olması. Dizi sıralandıktan sonra 18 sayısı hangi case kapsamına girer? Yazınız.

[7,3,5,8,2,9,4,15,6] dizisinin Insertion Sort'a göre ilk 4 adımını yazınız.

////////////////////////////////////////////////////////////////// 
public static void main(String args[]) { //
int dizi[]= {22,27,16,2,18,6}; /** { 2 6 16 18 22 27 } */ /** 18 avarage case olarak karşılık bulur.*/

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

//////////////////////////////////////////////

        1.{3,7,5,8,2,9,4,15,6}
        2.{3,5,7,8,2,9,4,15,6}
        3.{3,5,7,2,8,9,4,15,6}
        4.{3,5,2,7,8,9,4,15,6}
        5.{3,2,5,7,8,9,4,15,6}
        6.{2,3,5,7,8,9,4,15,6}
        7.{2,3,5,7,8,4,9,15,6}
        8.{2,3,5,7,4,8,9,15,6}
