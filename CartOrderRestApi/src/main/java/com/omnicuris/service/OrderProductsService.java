package com.omnicuris.service;

import com.omnicuris.dto.OrderDto;

public interface OrderProductsService {
	
	public void addItems(OrderDto batchDto);
	public OrderDto getOrder(int orderId);
}
