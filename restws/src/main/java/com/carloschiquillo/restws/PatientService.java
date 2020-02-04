package com.carloschiquillo.restws;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.carloschiquillo.restws.model.Patient;

import java.util.List;

@Path("/patientservice")
public interface PatientService {
	
	@Path("/patients")
	@GET
	List<Patient> getPatients();
	
	@Path("/patients/{id}")
	@GET
	Patient getPatient(@PathParam(value = "id") Long id);
	
	@Path("/patients")
	@POST
	Response createPatient(Patient patient);
}
