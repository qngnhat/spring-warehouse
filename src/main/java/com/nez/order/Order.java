package com.nez.order;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

import org.springframework.format.annotation.DateTimeFormat;

import com.nez.customer.Customer;
import com.nez.employee.Employee;
import com.nez.model.BaseEntity;
import com.sun.istack.NotNull;

@Entity
@Table(name = "Orders")
public class Order extends BaseEntity {
	static public enum State {
		PAID, DUE, CANCEL
	};

	@ManyToOne(optional = true)
	@JoinColumn(name = "customer_id", nullable = true)
	private Customer customer;
	@ManyToOne(optional = true)
	@JoinColumn(name = "employee_id", nullable = true)
	private Employee employee;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
	private Set<OrderItem> orderItems;
	@NotNull
	@DecimalMin(value = "0")
	private int total;
	@Enumerated(EnumType.STRING)
	private State state;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDate orderDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate transactionDate;
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

}