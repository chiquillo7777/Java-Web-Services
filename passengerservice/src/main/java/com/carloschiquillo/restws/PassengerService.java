package com.carloschiquillo.restws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.carloschiquillo.restws.model.Passenger;

@Path("/passengerservice")
@Produces("application/xml")
@Consumes("application/xml")
public interface PassengerService {
	
	@Path("/passengers")
	@GET
	List<Passenger> getPassenger();
	
	@Path("/passengers")
	@POST
	Passenger addPassenger(Passenger passenger);
}
