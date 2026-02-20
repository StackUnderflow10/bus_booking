package dao;

import model.Passenger;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerDao {
    public void bookTicket(int busId, Passenger passenger){
        String checkSeats = "SELECT available_seats FROM bus WHERE bus_id = ? FOR UPDATE";
        String bookSeats = "INSERT INTO passenger (name, age, booking_date, amount, bus_id, start_point, dest) VALUES (? ,?, ?, ?, ?, ?, ?)";
        String updateSeats = "UPDATE bus SET available_seats = available_seats - 1 WHERE bus_id = ?";

        Connection con =  null;
        try{
            con  = DBConnection.getConnection();
            con.setAutoCommit(false);

            PreparedStatement ps = con.prepareStatement(checkSeats);
            ps.setInt(1,busId);
            ResultSet rs = ps.executeQuery();

            int seats = 0;
            if(rs.next()){
                seats = rs.getInt("available_seats");
            }
            if(seats > 0){
                PreparedStatement insertPs = con.prepareStatement(bookSeats);
                insertPs.setString(1,passenger.getName());
                insertPs.setInt(2,passenger.getAge());
                insertPs.setString(3,passenger.getBookingDate());
                insertPs.setDouble(4,passenger.getAmount());
                insertPs.setInt(5,passenger.getBusId());
                insertPs.setString(6,passenger.getStartPoint());
                insertPs.setString(7,passenger.getDest());

                insertPs.executeUpdate();

                PreparedStatement updatePs = con.prepareStatement(updateSeats);
                updatePs.setInt(1,busId);
                updatePs.executeUpdate();

                con.commit();
                System.out.println("Success! Ticket booked for" + passenger.getPassId());
            }
            else{
                System.out.println("Sorry no seats available");
                con.rollback();
            }
            ps.close();
            rs.close();
        }
        catch (SQLException e) {

            System.out.println("Database error occurred. Rolling back changes.");
            try {
                if (con != null) con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();

        } finally {
            try {
                if (con != null) con.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
