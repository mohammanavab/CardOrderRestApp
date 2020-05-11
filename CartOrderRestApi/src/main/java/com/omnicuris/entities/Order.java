package com.omnicuris.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	private int orderId;
	private String customerNo;
	private Date orderDate;
	private List<Product> productItems;

	// getters and setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderId")
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Column(name = "customerNo")
	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	@Column(name = "orderCreatedDate")
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setProductItems(List<Product> productItems) {
		this.productItems = productItems;
	}

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Product> getProductItems() {
		return productItems;
	}

	public void addProduct(Product productItem) {
		if (productItems == null) {
			productItems = new ArrayList<Product>();
		}
		productItems.add(productItem);
	}

	public Order(int orderId, String customerNo, Date orderDate, List<Product> productItems) {
		super();
		this.orderId = orderId;
		this.customerNo = customerNo;
		this.orderDate = orderDate;
		this.productItems = productItems;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

}
