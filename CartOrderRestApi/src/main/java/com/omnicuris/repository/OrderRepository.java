package com.omnicuris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omnicuris.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	public Order findByOrderId(int id);

}
