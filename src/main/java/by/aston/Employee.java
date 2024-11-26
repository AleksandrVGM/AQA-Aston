package by.aston;

//task1
public class Employee {
    String FIO;
    String position;
    String email;
    String phone;
    int salary;
    int age;

    public Employee(String FIO, String position, String email, String phone, int salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + FIO + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
