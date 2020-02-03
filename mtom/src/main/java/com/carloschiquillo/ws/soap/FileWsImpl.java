package com.carloschiquillo.ws.soap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class FileWsImpl implements FileWs {

	@Override
	public void upload(DataHandler attachment) {
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = attachment.getInputStream();
			outputStream = new FileOutputStream(new File("C:\\Users\\carlos.chiquillo\\Documents\\workspace1\\Java-Web-Services\\mtom\\src\\main\\resources\\files\\uploaded\\test.jfif"));
			byte[] b = new byte[100000];
			int bytesRead = 0;
			
			while((bytesRead = inputStream.read(b))!= -1) {
				outputStream.write(b, 0, bytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}

	@Override
	public DataHandler download() {

		return new DataHandler(new FileDataSource(new File("C:\\Users\\carlos.chiquillo\\Documents\\workspace1\\Java-Web-Services\\mtom\\src\\main\\resources\\files\\uploaded\\test.jfif")));
	}

}
