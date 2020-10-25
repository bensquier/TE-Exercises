package com.techelevator.dao.jdbc;

import com.techelevator.dao.ReservationDAO;
import com.techelevator.model.Reservation;
import com.techelevator.model.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCReservationDAO implements ReservationDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCReservationDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int createReservation(int siteId, String name, LocalDate fromDate, LocalDate toDate) {
    	int confirmationId = 0;
    	String sqlCreateReservationReturnsReservationId =  "INSERT INTO reservation(site_id, name, from_date, to_date) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sqlCreateReservationReturnsReservationId, siteId, name, fromDate, toDate);
        
        String sqlFindReservationFromId = "SELECT reservation_id, site_id, name, from_date, to_date, create_date " +
        							"FROM reservation WHERE site_id = ? AND name = ? AND from_date = ? AND to_date = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlFindReservationFromId, siteId, name, fromDate, toDate);
        
        if(result.next()) {
        	mapRowToReservation(result);
        	confirmationId++;
        }
    	return confirmationId;
    }
    
    @Override
	public List<Reservation> upComingReservations() {
		ArrayList<Reservation> upcomingReservations = new ArrayList<Reservation>();
		String SqlGetUpcomingReservations = "SELECT reservation_id, site_id, name, from_date, to_date, create_date " +
									"FROM reservation WHERE to_date BETWEEN CURRENT_DATE AND (CURRENT_DATE + 30) ORDER BY to_date ASC";
		SqlRowSet result = jdbcTemplate.queryForRowSet(SqlGetUpcomingReservations);
		
		while(result.next()) {
			Reservation theReservation = mapRowToReservation(result);
			upcomingReservations.add(theReservation);
		}
		return upcomingReservations;
	}

    private Reservation mapRowToReservation(SqlRowSet results) {
        Reservation r = new Reservation();
        r.setReservationId(results.getInt("reservation_id"));
        r.setSiteId(results.getInt("site_id"));
        r.setName(results.getString("name"));
        r.setFromDate(results.getDate("from_date").toLocalDate());
        r.setToDate(results.getDate("to_date").toLocalDate());
        r.setCreateDate(results.getDate("create_date").toLocalDate());
        return r;
    }

	


}
