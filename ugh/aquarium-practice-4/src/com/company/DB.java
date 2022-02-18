package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {
    final static String url = "jdbc:postgresql://localhost:5432/laurent_project_1";
    final static String user = "postgres";
    final static String password = "12092004";


    public static List<Accessory> getAccessoriesByType(String type){
        try (
                Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement("SELECT * FROM accessories WHERE type=?");
        ) {
            pst.setString(1, type);
            try (ResultSet rs = pst.executeQuery()){
                List<Accessory> accessories = new ArrayList<>();
                while (rs.next()) {
                    Accessory accessory = new Accessory();
                    accessory.setName(rs.getString(1));
                    accessory.setCost(rs.getInt(3));
                    accessories.add(accessory);
                }
                return accessories;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
