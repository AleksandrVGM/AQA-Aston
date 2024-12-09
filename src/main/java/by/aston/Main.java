package by.aston;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //task2
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Bill Gates", "Retiree", "BillGates@gmail.com", "+375 84 5932659", 0, 69);
        employees[1] = new Employee("Elon Musk", "Twitter owner", "ElonMusk@gmail.com", "+375 42 5649281", 99, 53);
        employees[2] = new Employee("Larry Page", "CEO", "LarryPage@gmail.com", "+375 14 5843987", 999, 51);
        employees[3] = new Employee("Sergey Brin", "Co-founder Alphabet Inc.", "SergeyBrin.com", "+375 25 5894613", 9999, 51);
        employees[4] = new Employee("Larry Ellison", "CTO", "LarryEllison@gmail.com", "+375 28 3216548", 99999, 80);

        Park.Attraction attraction1 = new Park.Attraction("Ferris wheel", "10:00-22:00", 10);
        Park.Attraction attraction2 = new Park.Attraction("Rollercoaster", "10:00-22:00", 15);
        Park.Attraction attraction3 = new Park.Attraction("Bumper cars", "10:00-22:00", 20);
        Park.Attraction attraction4 = new Park.Attraction("Funhouse", "10:00-22:00", 25);
        Park.Attraction attraction5 = new Park.Attraction("Pendulum ride", "10:00-22:00", 18);
        Park park = new Park(new Park.Attraction[]{attraction1, attraction2, attraction3});
        park.addAttraction(attraction4);
        park.addAttraction(attraction5);

        System.out.println(park);
        park.deleteAttraction("Funhouse");

        System.out.println(park);
    }
}