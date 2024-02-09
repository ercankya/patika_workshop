package model;

public class Student {
    private String name, stdNo;
    private int classes;
    private Course math;
    private Course chemistry;
    private Course pyhsics;
    private Course comp_Science;

    private double avg;
    private boolean isPass;

    public Student() {
    }

    public Student(String name, String stdNo, int classes, Course math, Course chemistry, Course pyhsics) {
        this.name = name;
        this.stdNo = stdNo;
        this.classes = classes;
        this.math = math;
        this.chemistry = chemistry;
        this.pyhsics = pyhsics;
        this.isPass = false;
        calcAvg();
    }

    public void isPass() {
        if (this.math.getNote() == 0 || this.pyhsics.getNote() == 0 || this.chemistry.getNote() == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " +String.format("%,.2f", this.avg));
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvg() {
        this.avg = (double) (this.pyhsics.getNote() + this.chemistry.getNote() + this.math.getNote()) / 3;
    }

    public boolean isCheckPass() {
        calcAvg();
        return this.avg > 55;
    }

    public void printNote() {
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.math.getNote());
        System.out.println("Fizik Notu : " + this.pyhsics.getNote());
        System.out.println("Kimya Notu : " + this.chemistry.getNote());
    }

    public void addBulkExamNote(int math, int pyhsics, int chemistry) {

        if (math >= 0 && math <= 100) {
            this.math.setNote(math);
        }

        if (pyhsics >= 0 && pyhsics <= 100) {
            this.pyhsics.setNote(pyhsics);
        }

        if (chemistry >= 0 && chemistry <= 100) {
            this.chemistry.setNote(chemistry);
        }
    }

    public void addOtherExamNote(int math, int pyhsics, int chemistry) {

        if (math >= 0 && math <= 100) {
            this.math.setNote(math * 0.2 + this.math.getNote() * 0.8);
        }

        if (pyhsics >= 0 && pyhsics <= 100) {
            this.pyhsics.setNote(pyhsics * 0.2 + this.pyhsics.getNote() * 0.8);

        }

        if (chemistry >= 0 && chemistry <= 100) {
            this.chemistry.setNote(chemistry * 0.2 + this.chemistry.getNote() * 0.8);

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStdNo() {
        return stdNo;
    }

    public void setStdNo(String stdNo) {
        this.stdNo = stdNo;
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }

    public Course getMath() {
        return math;
    }

    public void setMath(Course math) {
        this.math = math;
    }

    public Course getChemistry() {
        return chemistry;
    }

    public void setChemistry(Course chemistry) {
        this.chemistry = chemistry;
    }

    public Course getPyhsics() {
        return pyhsics;
    }

    public void setPyhsics(Course pyhsics) {
        this.pyhsics = pyhsics;
    }

    public Course getComp_Science() {
        return comp_Science;
    }

    public void setComp_Science(Course comp_Science) {
        this.comp_Science = comp_Science;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }
}
