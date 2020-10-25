package com.techelevator.dao.jdbc;

import com.techelevator.dao.SiteDAO;
import com.techelevator.model.Site;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JDBCSiteDAOTests extends BaseDAOTests {

    private SiteDAO dao;
    private JdbcTemplate jdbcTemplate;


    @Before
    public void setup() {
        dao = new JDBCSiteDAO(dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
        
    }

    @Test
    public void getSitesThatAllowRVs_Should_ReturnSites() {
        List<Site> sites = dao.getSitesThatAllowRVs(1);

        assertEquals(20,sites.size());
    }

    @Test
    public void getAvailableSites_Should_ReturnSites() {
    	String sqlNumberOfAvailableSites = "SELECT COUNT(*) " +
    			"FROM site s " + 
    			"LEFT JOIN reservation r ON s.site_id = r.site_id " + 
    			"LEFT JOIN campground c ON s.campground_id = c.campground_id " + 
    			"WHERE park_id = 1 " + 
    			"AND CURRENT_DATE NOT BETWEEN from_date AND to_date " + 
    			"OR r.site_id IS NULL";
    	long numberOfAvailableSites = jdbcTemplate.queryForObject(sqlNumberOfAvailableSites, long.class);
    	
    	List<Site> availableSites = dao.getAvailableSites(1);
    	
    	assertNotNull(availableSites);
    	assertEquals(numberOfAvailableSites, availableSites.size());
    	
    }

    @Test
    public void getAvailableSitesDateRange_Should_ReturnSites() {
    	String sqlNumberOfAvailableSitesDateRange = "SELECT COUNT(*) FROM site s " + 
    			"LEFT JOIN reservation r ON s.site_id = r.site_id " + 
    			"LEFT JOIN campground c ON s.campground_id = c.campground_id " + 
    			"WHERE park_id = 1 " + 
    			"AND from_date NOT BETWEEN '2020-10-21'::date AND '2020-10-24'::date " + 
    			"AND to_date NOT BETWEEN '2020-10-21'::date AND '2020-10-24'::date;";
    	long numberOfAvailableSites = jdbcTemplate.queryForObject(sqlNumberOfAvailableSitesDateRange, long.class);
    	
    	List<Site> availableSites = dao.getAvailableSitesDateRange(1, LocalDate.parse("2020-10-21"), LocalDate.parse("2020-10-24"));
    	
    	assertNotNull(availableSites);
    	assertEquals(numberOfAvailableSites, availableSites.size());

    }
    
}
