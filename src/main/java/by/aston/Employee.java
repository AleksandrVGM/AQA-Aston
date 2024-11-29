package by.aston;

//task1
public class Employee {
    private String FIO;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

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

    public static void main(String[] args) {
        //task2
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Bill Gates", "Retiree", "BillGates@gmail.com", "+375 84 5932659", 0, 69);
        employees[1] = new Employee("Elon Musk", "Twitter owner", "ElonMusk@gmail.com", "+375 42 5649281", 99, 53);
        employees[2] = new Employee("Larry Page", "CEO", "LarryPage@gmail.com", "+375 14 5843987", 999, 51);
        employees[3] = new Employee("Sergey Brin", "Co-founder Alphabet Inc.", "SergeyBrin.com", "+375 25 5894613", 9999, 51);
        employees[4] = new Employee("Larry Ellison", "CTO", "LarryEllison@gmail.com", "+375 28 3216548", 99999, 80);
    }
}
