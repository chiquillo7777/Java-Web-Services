package com.carloschiquillo.restws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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
	public Passenger addPassenger(Passenger passenger) {
		
		passenger.setId(currentId++);
		passengers.add(passenger);
		
		return passenger;
	}

}
