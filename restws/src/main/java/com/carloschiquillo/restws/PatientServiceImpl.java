package com.carloschiquillo.restws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.carloschiquillo.restws.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {
	Map<Long, Patient> patients = new HashMap<>();
	Long currentId = (long) 123;
	public PatientServiceImpl() {
		init();
	}
	
	void init() {
		Patient patient = new Patient();
		patient.setId(currentId);
		patient.setName("John");
		patients.put(patient.getId(), patient);
	}

	
	@Override
	public List<Patient> getPatients() {
		Collection<Patient> results = patients.values();
		List<Patient> response = new ArrayList<>(results);
		return response;
	}

	@Override
	public Patient getPatient(Long id) {
		
		
		
		return patients.get(id);
	}

	@Override
	public Response createPatient(Patient patient) {
		patient.setId(++currentId);
		patients.put(patient.getId(), patient);
		
		return Response.ok(patient).build();
	}
}
