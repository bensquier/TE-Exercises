package com.techelevator.dao.jdbc;

import com.techelevator.dao.SiteDAO;
import com.techelevator.model.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCSiteDAO implements SiteDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCSiteDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Site> getSitesThatAllowRVs(int parkId) {
    	ArrayList<Site> sites = new ArrayList<Site>();
    	String sqlGetSitesThatAllowRvs = "SELECT s.site_id, s.campground_id, s.site_number, s.max_occupancy, s.accessible, s.max_rv_length, s.utilities " +
    									"FROM site s INNER JOIN campground c ON s.campground_id = c.campground_id " +
    									"WHERE max_rv_length != 0 AND c.park_id = ?";
    	SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetSitesThatAllowRvs, parkId);
    	
    	while(result.next()) {
    		Site theSite = mapRowToSite(result);
    		sites.add(theSite);
    	}
        return sites;
    }
    
    @Override
	public List<Site> getAvailableSites(int parkId) {
    	List<Site> sites = new ArrayList<Site>();
    	String sqlGetAvailableSites = "SELECT s.site_id, s.campground_id, s.site_number, s.max_occupancy, s.accessible, s.max_rv_length, s.utilities " +
    				"FROM site s " + 
    				"LEFT JOIN reservation r ON s.site_id = r.site_id " + 
    				"LEFT JOIN campground c ON s.campground_id = c.campground_id " + 
    				"WHERE park_id = ? " + 
    				"AND CURRENT_DATE NOT BETWEEN from_date AND to_date " + 
    				"OR r.site_id IS NULL";
    	SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetAvailableSites, parkId);
    	
    	while(result.next()) {
    		Site theSite = mapRowToSite(result);
    		sites.add(theSite);
    	}
    	
    	return sites;
	}
    
    @Override
	public List<Site> getAvailableSitesDateRange(int parkId, LocalDate startDate, LocalDate endDate) {
    	List<Site> sites = new ArrayList<Site>();
    	String sqlGetAvailableSitesDateRange = "SELECT s.site_id, s.campground_id, s.site_number, s.max_occupancy, s.accessible, s.max_rv_length, s.utilities " +
    			"FROM site s " + 
    			"LEFT JOIN reservation r ON s.site_id = r.site_id " + 
    			"LEFT JOIN campground c ON s.campground_id = c.campground_id " + 
    			"WHERE park_id = ? " + 
    			"AND from_date NOT BETWEEN ? AND ? " + 
    			"AND to_date NOT BETWEEN ? AND ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetAvailableSitesDateRange, parkId, startDate, endDate, startDate, endDate);
		
		while(result.next()) {
			Site theSite = mapRowToSite(result);
			sites.add(theSite);
		}
;		return sites;
	}
 
    
    private Site mapRowToSite(SqlRowSet results) {
        Site site = new Site();
        site.setSiteId(results.getInt("site_id"));
        site.setCampgroundId(results.getInt("campground_id"));
        site.setSiteNumber(results.getInt("site_number"));
        site.setMaxOccupancy(results.getInt("max_occupancy"));
        site.setAccessible(results.getBoolean("accessible"));
        site.setMaxRvLength(results.getInt("max_rv_length"));
        site.setUtilities(results.getBoolean("utilities"));
        return site;
    }

	

	
}
