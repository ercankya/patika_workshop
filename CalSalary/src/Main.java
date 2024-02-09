import model.Employee;

public class Main {
    public static void main(String[] args) {
        Employee Ercan=new Employee("Ercan KAYA",20000,50,2016);
        Employee Selami=new Employee("Selami ŞAHİN",10000,40,2001);
        Ercan.employeeInfo();
        Selami.employeeInfo();
    }
}
