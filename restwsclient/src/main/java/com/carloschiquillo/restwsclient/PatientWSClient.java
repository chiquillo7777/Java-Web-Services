package com.carloschiquillo.restwsclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.carloschiquillo.restwsclient.model.Patient;

public class PatientWSClient {

	private static final String PATIENTS = "/patients";
	private static final String PATIENT_SERVICE_URL = "http://localhost:8080/restws/services/patientservice";

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(PATIENT_SERVICE_URL).path(PATIENTS).path("/{id}").resolveTemplate("id", 126);
		Builder request= target.request();
		Patient patient = request.get(Patient.class);
		
		System.out.println(patient.getId());
		System.out.println(patient.getName());
		
		patient.setName("chiquillo45");
		
		WebTarget putTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS);
		Response updateResponse = putTarget.request().put(Entity.entity(patient, MediaType.APPLICATION_XML));
		//clean resources
		updateResponse.close();
		System.out.println(updateResponse.getStatus());
		
		//create new patient
		Patient newPatient = new Patient();
		newPatient.setName("DavidEdgardo");
		
		WebTarget postTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS);
		Patient createdPatient = postTarget.request().post(Entity.entity(newPatient, MediaType.APPLICATION_XML), Patient.class);
		System.out.println("Create patient id: " + createdPatient.getId());
		
		//deletePatient assignment
		WebTarget deleteTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS).path("/{id}").resolveTemplate("id", 128);
		Builder deleteBuilder = deleteTarget.request();
		Response deletedResponse = deleteTarget.request().delete();
		//clean resources
		client.close();
	}

}
