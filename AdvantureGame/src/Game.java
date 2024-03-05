import model.Player;
import model.chars.Archer;
import model.chars.GameChar;
import model.chars.Knight;
import model.chars.Samurai;
import model.locs.Location;
import model.locs.battleLocs.Cave;
import model.locs.battleLocs.Forest;
import model.locs.battleLocs.Mine;
import model.locs.battleLocs.River;
import model.locs.normLocs.SafeHouse;
import model.locs.normLocs.ToolStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    protected Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("+----------------------------+");
        System.out.println("+ Macera Oyununa hoşgeldiniz +");
        System.out.println("+----------------------------+");

        System.out.print("Lütfen isim giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);

        System.out.println(player.getName() + "  Karanlık ve sisli yolculuğa ilk adımınızı attınız tebrikler !");
        System.out.println();

        player = selectChar(player);
        System.out.println();

        selectLoc(player);
        System.out.println();

    }

    Player selectChar(Player player) {
        System.out.println("Şimdi Bir karakter seçin :");
        List<GameChar> charList = new ArrayList<>();
        charList.add(new Archer());
        charList.add(new Knight());
        charList.add(new Samurai());

        System.out.println("--------------------------------------------------------------------------------------------");
        for (GameChar gamechar : charList) {
            System.out.println(gamechar.getId() + ". " + gamechar.getCharName() + "\t Güç : " + gamechar.getDamage() + "\t Sağlık : " + gamechar.getHealth() + "\t Para : " + gamechar.getMoney());
        }
        int ch = input.nextInt();
        while (ch > charList.size() || ch < 0) {
            System.out.println("Geçersiz değer girişi, Tekrar giriniz : ");
        }
        player.setGameChar(charList.get(ch - 1));
        System.out.println("--------------------------------------------------------------------------------------------");
        return player;
    }

    public boolean selectLoc(Player player) {
        Location location = null;
        while (true) {
            player.showPlayerInfo();

            System.out.println("+-----\t    \t       \t-----+");
            System.out.println("+#####\t BÖLGELER    \t#####+");
            System.out.println("+-----\t    \t       \t-----+");

            System.out.println("1- Güvenli Ev --> Düşman yok. Canını fulle ve Envanterini kullan.");
            System.out.println("2- ToolStore --> Silah ve zırh satın alabilirsin.");
            System.out.println("3- Mağara --> Burada bıkmaz usanmaz zombiler var Dikkatli ol.. -Su");
            System.out.println("4- Orman --> Buradaki hayvanlar biraz fazla vahşi.Ayının nereden çıkacağı belli olmaz!  -Odun");
            System.out.println("5- Nehir --> Buradaki kadim yaratıklar fokurdayan kanına bayılacak, Vampirrrrrrr  ahaaaaahğa!!!  -Yemek");
            System.out.println("6- Maden --> Ssss ssss Zehirli yılanlara var burda -Rasgele Eşya");
            System.out.println("0- Çıkış --> ");
            System.out.println();

            System.out.print("Şimdi bir bölge seçin : ");
            int selectLoc = input.nextInt();
            System.out.println("--------------------------------------------------------------------------------------------");

            switch (selectLoc) {
                case 0:
                    System.out.println("Bu Gizemli ve tehlikeli yolculuğu bırakıyorsun ha.");
                    return true;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Geçerli bir bölge seçin");
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER");
                return true;
            }
        }
    }
}
