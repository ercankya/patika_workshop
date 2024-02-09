import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int m, n;

        Scanner input = new Scanner(System.in);
        System.out.println("row value: ");
        m = input.nextInt();
        System.out.println("column value: ");
        n = input.nextInt();

        MineSweeper mf = new MineSweeper(m,n);
        mf.game();
    }

}
