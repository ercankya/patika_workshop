import model.Fighter;
import model.Ring;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        Fighter marc = new Fighter("Marc" , 15 , 100, 90, 0);
        Fighter alex = new Fighter("Alex" , 10 , 95, 100, 0);

        Ring r = new Ring(marc,alex , 90 , 100);
        if (rand.nextInt(2)%2==0){
            r = new Ring(alex,marc , 90 , 100);
        }
        r.run();
    }
}
