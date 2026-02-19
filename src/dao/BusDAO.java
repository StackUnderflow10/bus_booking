package dao;

import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
