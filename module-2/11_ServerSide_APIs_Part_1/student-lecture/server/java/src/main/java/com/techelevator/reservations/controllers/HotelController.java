package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.MemoryHotelDAO;
import com.techelevator.reservations.dao.MemoryReservationDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    private HotelDAO hotelDAO;
    private ReservationDAO reservationDAO;

    public HotelController() {
        this.hotelDAO = new MemoryHotelDAO();
        this.reservationDAO = new MemoryReservationDAO(hotelDAO);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list() {
        return hotelDAO.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDAO.get(id);
    }
    
    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservations() {
    	return reservationDAO.findAll();
    }

    @RequestMapping(path = "reservations/{id}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable int id) {
    	Reservation result = null;
    	try {
    		result = reservationDAO.get(id);
    	} catch (Exception ex) {
    		//Log DAO error
    	}
    	return result;
    }
    
    @RequestMapping(path = "hotels/{hotelId}/reservations", method = RequestMethod.GET)
    public List<Reservation> getReservationsByHotel(@PathVariable int hotelId) {
    	List<Reservation> result = null;
    	try {
    		result = reservationDAO.findByHotel(hotelId);
    	}catch(Exception ex) {
    		//Log DAO error.
    	}
    	return result;
    }
    
    @RequestMapping(path = "/hotels/{hotelId}/reservations", method = RequestMethod.POST)
    public Reservation createReservation(@RequestBody Reservation newReservation, @PathVariable int hotelId) {
    	Reservation result = null;
    try {
    	result = reservationDAO.create(newReservation, hotelId);
    } catch(Exception ex) {
    	//Log DAO error
    }
    return result;
    }
    
    @RequestMapping(path = "/filter", method = RequestMethod.GET)
    public List<Hotel> filterByCityAndState(@RequestParam String state, @RequestParam(required = false) String city) {
    	List<Hotel> filteredResult = new ArrayList<Hotel>();
    	List<Hotel> hotels = hotelDAO.list();
    	
    	for(Hotel hotel : hotels) {
    		
    		if(city != null) {
    			if(hotel.getAddress().getCity().toUpperCase().equals(city.toUpperCase()) && hotel.getAddress().getState().toUpperCase().equals(state.toUpperCase())){
        			filteredResult.add(hotel);
        		}
    		} else {
    		
    		if(hotel.getAddress().getState().toUpperCase().equals(state.toUpperCase())){
    			filteredResult.add(hotel);
    			}
    		}
    	}
    	
    	return filteredResult;
    }
    
     @RequestMapping(path = "reservations/{resID}", method = RequestMethod.DELETE)
     public void deleteReservation(@PathVariable int resID) {
    	 //reservationDAO.delete;
     }
}
