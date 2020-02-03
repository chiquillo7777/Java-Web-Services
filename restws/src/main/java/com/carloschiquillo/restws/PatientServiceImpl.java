package com.carloschiquillo.restws;

import java.util.HashMap;
import java.util.Map;

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
}
