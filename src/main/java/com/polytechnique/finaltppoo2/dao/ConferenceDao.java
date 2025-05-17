package com.polytechnique.finaltppoo2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.polytechnique.finaltppoo2.dao.exceptions.EntityNotFoundException;
import com.polytechnique.finaltppoo2.dao.exceptions.EntityNotFoundException.EntityName;
import com.polytechnique.finaltppoo2.model.Conference;

public class ConferenceDao {
    /* DB connection */
    private Connection conn; 

    /* default contructor */
    public ConferenceDao(Connection conn) {
        this.conn = conn; 
    }

    /* methods for CRUD */

    public void addConference(Conference conf) throws SQLException{
        String query = "INSERT INTO TABLE Conference(name, date, location, maxCapacity, theme) VALUES(?, ?, ?, ?, ?); "; 

        try {
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, conf.getName());

            /* here we convert the localDateTime into a timeStamp with will be convert into a mysql DateTime */
            stmt.setTimestamp(2, Timestamp.valueOf(conf.getDate()));

            stmt.setString(3, conf.getLocation()); 
            stmt.setInt(4, conf.getMaxCapacity());
            stmt.setString(5, conf.getTheme());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage()); 
        } 
    }

    public Conference getConference(int id) throws EntityNotFoundException {

        Conference conf;

        String query = "SELECT name, date, location, maxCapacity, theme FROM Conference WHERE id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery(); 

            if(!result.next()) {
                /* the conference with that id is not found */
                throw new EntityNotFoundException(EntityName.CONFERENCE); 
            } else {
                String name = result.getString("name");
                LocalDateTime date = result.getTimestamp("date").toLocalDateTime();
                String location = result.getString("location"); 
                int maxCapacity = result.getInt("maxCapacity");
                String theme = result.getString("theme"); 

                conf = new Conference(id, name, date, location, maxCapacity, theme);
                return conf; 
            }
        } catch(SQLException _) {
            throw new EntityNotFoundException(EntityName.CONFERENCE);  
        }
    }

}
