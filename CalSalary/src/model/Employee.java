package model;

public class Employee {
    private String name;
    private double salary;
    private int workHours;
    private int hireYear;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public double tax(){
        double taxSalary=0;
        if(salary+bonus()>1000){
            return (((salary+bonus())*3)/100);
        }
        return taxSalary;
    }
    public int bonus(){
        int overtimeSalary=0;
        if(workHours>40){
            overtimeSalary=(workHours-40)*30;
            return overtimeSalary;
        }else
            return 0;
    }
    public double raiseSalary(){
        double extra=0;
        if((2022-hireYear)<10){
            extra=(salary*5)/100;
        }
        if((2022-hireYear)>9&&(2022-hireYear)<20) {
            extra=(salary*10)/100;
        }
        if((2022-hireYear)>20){
            extra=(salary*15)/100;
        }
        return extra;
    }
    public void employeeInfo(){
        System.out.println("--------------------------------------------");
        System.out.println("Name:"+this.name);
        System.out.println("Start year:"+this.hireYear);
        System.out.println("Salary:"+this.salary+" USD");
        System.out.println("WorkHours:"+this.workHours);
        System.out.println("Tax: " + tax() + " USD");
        System.out.println("Bonus:" + bonus() + " USD");
        System.out.println("Extra:" + raiseSalary() + " USD");
        System.out.println("Net Salary:" + (this.salary + bonus() - tax() + raiseSalary()) + " USD");

        System.out.println("--------------------------------------------");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public int getHireYear() {
        return hireYear;
    }

    public void setHireYear(int hireYear) {
        this.hireYear = hireYear;
    }
}
