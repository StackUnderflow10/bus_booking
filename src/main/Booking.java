package main;

import dao.BusDAO;
import dao.PassengerDao;
import model.Passenger;

import java.util.Scanner;

public class Booking {
    public static void main(String[] args) {

        Scanner sc =  new Scanner(System.in);

        System.out.println("Enter Bus ID to book:");
        int busId = sc.nextInt();
        System.out.println("Enter your name:");
        String name = sc.next();
        System.out.println("Enter your age:");
        int age = sc.nextInt();
        System.out.println("Enter booking date (yyyy-mm-dd):");
        String date = sc.next();
        System.out.println("Enter amount:");
        double amount = sc.nextDouble();
        System.out.println("Enter your boarding point:");
        String start = sc.next();
        System.out.println("Enter your destination:");
        String dest = sc.next();

        Passenger passenger = new Passenger(
                name,
                age,
                date,
                amount,
                busId,
                start,
                dest
        );

        PassengerDao passDao = new PassengerDao();
        passDao.bookTicket(busId,passenger);



    }
}
