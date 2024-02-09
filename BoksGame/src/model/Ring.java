package model;

public class Ring {
    private Fighter f1;
    private Fighter f2;
    private int minWeight;
    private int maxWeight;

    public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public void run() {

        if (checkWeight()) {
            while (f1.getHealth() > 0 && f2.getHealth() > 0) {
                System.out.println("======== YENİ ROUND ===========");
                f2.setHealth(f1.hit(f2));

                if (isWin()){
                    break;
                }
                f1.setHealth(f2.hit(f1));
                if (isWin()){
                    break;
                }
                printScore();
            }

        } else {
            System.out.println("Sporcuların ağırlıkları uyuşmuyor.");
        }


    }

    public boolean checkWeight() {
        return (f1.getWeight() >= minWeight && f1.getWeight() <= maxWeight) && (f2.getWeight() >= minWeight && f2.getWeight() <= maxWeight);
    }

    public boolean isWin() {
        if (f1.getHealth() == 0) {
            System.out.println("Maçı Kazanan : " + f2.getName());
            return true;
        } else if (f2.getHealth() == 0){
            System.out.println("Maçı Kazanan : " + f2.getName());
            return true;
        }

        return false;
    }


    public void printScore() {
        System.out.println("------------");
        System.out.println(f1.getName() + " Kalan Can \t:" + f1.getHealth());
        System.out.println(f2.getName() + " Kalan Can \t:" + f2.getHealth());
    }

    public Fighter getF1() {
        return f1;
    }

    public void setF1(Fighter f1) {
        this.f1 = f1;
    }

    public Fighter getF2() {
        return f2;
    }

    public void setF2(Fighter f2) {
        this.f2 = f2;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(int minWeight) {
        this.minWeight = minWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
}
