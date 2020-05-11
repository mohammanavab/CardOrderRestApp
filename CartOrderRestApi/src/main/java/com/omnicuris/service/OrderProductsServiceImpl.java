package com.omnicuris.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnicuris.dto.OrderDto;
import com.omnicuris.dto.ProductDto;
import com.omnicuris.entities.Order;
import com.omnicuris.entities.Product;
import com.omnicuris.repository.OrderRepository;
import com.omnicuris.repository.ProductRepository;

@Service
public class OrderProductsServiceImpl implements OrderProductsService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public void addItems(OrderDto orderDto) {
		
		try {
			Order order = new Order();
			Product product = null;
			order.setCustomerNo(orderDto.getCustomerNo());

			order.setOrderDate(orderDto.getOrderDate());
		
			// iterating over the products items
			for (ProductDto productDto : orderDto.getProducts()) {
				product = new Product();
				product.setName(productDto.getName());
				product.setDescription(productDto.getDescription());
				product.setPrice(productDto.getPrice());
				product.setQuantity(productDto.getQuantity());
				product.setProductNo(productDto.getProductNo());
				product.setOrder(order);
				order.addProduct(product);
			}
			orderRepository.save(order);
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	public OrderDto getOrder(int orderId) {
		OrderDto orderDto = null;
		List<ProductDto> productList = null;
		try {
			Order order = orderRepository.findByOrderId(orderId);
			if (order != null) {
				orderDto=new OrderDto();
				productList = new ArrayList<>();
				ProductDto productDto = null;

				for (Product product : order.getProductItems()) {
					productDto = new ProductDto();
					productDto.setName(product.getName());
					productDto.setDescription(product.getDescription());
					productDto.setPrice(product.getPrice());
					productDto.setQuantity(product.getQuantity());
					productDto.setProductNo(product.getProductNo());
					productList.add(productDto);
				}
				orderDto.setProducts(productList);
				orderDto.setCustomerNo(order.getCustomerNo());
				orderDto.setOrderDate(order.getOrderDate());
				return orderDto;
				}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
