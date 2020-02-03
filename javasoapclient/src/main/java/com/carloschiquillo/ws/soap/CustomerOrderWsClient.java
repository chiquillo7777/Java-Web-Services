package com.carloschiquillo.ws.soap;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.bharath.ws.trainings.*;

// testing34
public class CustomerOrderWsClient {

	public static void main(String[] args) throws MalformedURLException {
		CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(new URL("http://localhost:8080/wsdlfirstws/customerordersservice?wsdl"));
		CustomerOrdersPortType customerOrdersPort = service.getCustomerOrdersWsImplPort();
		
		GetOrdersRequest request = new GetOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		GetOrdersResponse response = customerOrdersPort.getOrders(request);
		
		//will create a Create request
		CreateOrdersRequest createRequest = new CreateOrdersRequest();
		createRequest.setCustomerId(BigInteger.valueOf(1));
		
		Product product = new Product();
		product.setId("5");
		product.setDescription("cows");
		product.setQuantity(BigInteger.valueOf(5));
		
		Order order = new Order();
		order.getProduct().add(product);
		
		
		createRequest.setOrder(order);
		
		CreateOrdersResponse createResponse = customerOrdersPort.createOrders(createRequest);
		
		
		List<Order> orders = response.getOrder();
		System.out.println("response is: " + createResponse);

	}

}
