package dao;

import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BusDAO {
    public void getAllBuses(){
        String query = "SELECT * FROM bus";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery();
        ){
            while(rs.next()){
                System.out.println(rs.getInt("bus_id") + "|" + rs.getString("bus_no") + "|" + rs.getInt("available_seats"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void addBus() {
        String query = "INSERT INTO bus (bus_no, capacity, available_seats, start_point, dest, travel_data) VALUES (?, ?, ?, ?, ?, ?) ";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             Scanner sc = new Scanner(System.in);)
        {

            while(true) {
                System.out.println("Enter bus no");
                String busNo = sc.next();
                System.out.println("Enter capacity");
                int capacity = sc.nextInt();
                System.out.println("Available seats :");
                int available = sc.nextInt();
                System.out.println("Starting Point: ");
                String sPoint = sc.next();
                System.out.println("Destination:");
                String dest = sc.next();
                System.out.println("Travel Date: ");
                String date = sc.next();
                System.out.println("Enter more data(Y/N)");
                String choice  = sc.next();

                ps.setString(1,busNo);
                ps.setInt(2,capacity);
                ps.setInt(3,available);
                ps.setString(4,sPoint);
                ps.setString(5,dest);
                ps.setString(6,date);

                ps.addBatch();
                if(choice.toUpperCase().equals("N")) break;
            }
            int[] arr = ps.executeBatch();
            System.out.println("data inserted");

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void searchBus(String startPoint, String destination, String date){
        String query = "SELECT * FROM bus WHERE LOWER(start_point) = (LOWER)? AND (LOWER)dest = (LOWER)? AND travel_data = ? AND available_seats > 0";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();)
        {
            ps.setString(1,startPoint);
            ps.setString(2,destination);
            ps.setString(3,date);

            boolean isFound  = false;

            while(rs.next()){
                isFound = true;
                System.out.println( "ID: " + rs.getInt("bus_id") +
                        " | Bus No: " + rs.getString("bus_no") +
                        " | Seats: " + rs.getInt("available_seats"));
            }
            if(!isFound){
                System.out.println("No buses available");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
