package com.omnicuris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.omnicuris.dto.OrderDto;
import com.omnicuris.service.OrderProductsService;

@RestController
public class OrderProductsController {

	@Autowired
	OrderProductsService productService;


	// creating new order
	@PostMapping(path = "/createNewOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addItems(@RequestBody OrderDto orderDto) {
		productService.addItems(orderDto);
	}

	// getting specific orderId
	@GetMapping(path = "/getOrderInfo/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderDto> getOrderById(@PathVariable("orderId") int orderId) {
		OrderDto orderDto = productService.getOrder(orderId);
		
			return new ResponseEntity<OrderDto>(orderDto, new
				HttpHeaders(), HttpStatus.OK);
			
	}

}
