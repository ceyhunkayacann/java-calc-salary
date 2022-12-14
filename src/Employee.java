import java.time.LocalDate;

public class Employee {
    String name;
    double salary;
    int workHours;
    int hireYear;
    int currentYear;
    double totalSalary;
    double afterTax;

    LocalDate date = LocalDate.now();
    Employee(String name, double salary, int workHours,int hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
        this.currentYear = date.getYear();
        this.totalSalary = this.salary + this.bonus() + this.raiseSalary();
        this.afterTax = this.totalSalary - this.tax();
    }

    int tax(){
        if (this.salary > 1000){
            return (int) ((this.salary * 3) / 100);
        }
        else {
            return 0;
        }

    }

    int bonus(){
        if(this.workHours > 40){
            return (this.workHours - 40) * 30;
        }
        return 0;
    }

    int raiseSalary(){
        int year = this.currentYear - this.hireYear;
        if(year < 10){
            return (int) ((this.salary * 5) / 100);
        }

        if(year >= 10 && year < 20) {
            return (int) ((this.salary * 10) / 100);
        }

        if (year >= 20) {
            return (int) ((this.salary * 15) / 100);
        }
        return 0;
    }

    void toPrint(){
        System.out.printf("Name : %s\n", this.name);
        System.out.printf("Salary : %s ₺\n", (int)this.salary);
        System.out.printf("Working Hour Per Week : %s hours\n", this.workHours);
        System.out.printf("Starting Year : %s \n", this.hireYear);
        System.out.printf("Tax : %s ₺\n", this.tax());
        System.out.printf("Extras : %s ₺\n", this.bonus());
        System.out.printf("Pay Raise : %s ₺\n", this.raiseSalary());
        System.out.printf("Total Salary : %s ₺\n", (int)this.totalSalary);
        System.out.printf("After Tax : %s ₺\n", (int)this.afterTax);
    }
}
