package com.carloschiquillo.restws;

import javax.ws.rs.container.AsyncResponse;

import org.springframework.stereotype.Service;
import com.carloschiquillo.restws.model.ChecksList;

@Service
public class CheckProcessorImpl implements CheckProcessor {

	@Override
	public void processChecks(AsyncResponse response, ChecksList checksList) {
		
		new Thread() {
			public void run() {
				response.resume(true);
			}
		}.start();
		
		
	}

}
