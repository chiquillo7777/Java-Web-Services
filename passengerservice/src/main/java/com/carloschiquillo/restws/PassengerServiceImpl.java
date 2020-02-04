package com.carloschiquillo.restws;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.HttpHeaders;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.carloschiquillo.restws.model.Passenger;

@Service
public class PassengerServiceImpl implements PassengerService {

	List<Passenger> passengers = new ArrayList<>();
	int currentId = 123;
	@Override
	public List<Passenger> getPassenger(int start, int size) {
		System.out.println(start);
		System.out.println(size);

		return passengers;
	}
	@Override
	public void addPassenger(String firstName, String lastName, String agent, HttpHeaders headers) {
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(agent);
		@SuppressWarnings("unchecked")
		MultiValueMap<String, String> allHeaders =  (MultiValueMap<String, String>) headers.getRequestHeaders();
		Set<String> headerKeys = allHeaders.keySet();
		
		for(String key: headerKeys) {
			System.out.println(key);
			System.out.println(headers.getHeaderString(key));
		}
		
	}

	

}
