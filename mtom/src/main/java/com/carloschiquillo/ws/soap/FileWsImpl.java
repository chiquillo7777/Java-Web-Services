package com.carloschiquillo.ws.soap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;

public class FileWsImpl implements FileWs {

	@Override
	public void upload(DataHandler attachment) {
		
		
		try {
			InputStream inputStream = attachment.getInputStream();
			OutputStream outputStream = new FileOutputStream(new File("C:\\Users\\carlos.chiquillo\\Documents\\workspace1\\Java-Web-Services\\mtom\\src\\main\\resources\\files\\uploaded\\test.jfif"));
			byte[] b = new byte[100000];
			int bytesRead = 0;
			
			while((bytesRead = inputStream.read(b))!= -1) {
				outputStream.write(b, 0, bytesRead);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public DataHandler download() {
		// TODO Auto-generated method stub
		return null;
	}

}
