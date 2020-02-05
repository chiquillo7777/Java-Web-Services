package com.carloschiquillo.restws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;

public class FileClient {

	public static void main(String[] args) throws FileNotFoundException {
		WebClient client = WebClient.create("http://localhost:8080/restattachments/services/fileservice/upload");
		client.type("multipart/form-data");
		ContentDisposition cd = new ContentDisposition("attachment;filename=Fatywallpaper.jpg");
		
		Attachment attachment = new Attachment("root", new FileInputStream(new File("C:\\Users\\Carlos Chiquillo\\OneDrive\\Fotos\\Fatywallpaper.jpg")), cd);
		client.post(attachment);
	}

}
