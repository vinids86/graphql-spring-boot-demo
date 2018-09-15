package br.com.saraiva.graphqldemo.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

/**
 * Created by sara on set, 2018
 */
public class Order {
	private String id;
	private String petId;
	private Integer quantity;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime shipDate;
	private OrderStatus status;
	private Boolean complete;

	public Order() {
	}

	public Order(String petId, Integer quantity, LocalDateTime shipDate,
			OrderStatus status, Boolean complete) {
		this(null, petId, quantity, shipDate, status, complete);
	}

	public Order(String id, String petId, Integer quantity, LocalDateTime shipDate,
			OrderStatus status, Boolean complete) {
		this.id = id;
		this.petId = petId;
		this.quantity = quantity;
		this.shipDate = shipDate;
		this.status = status;
		this.complete = complete;
	}

	public String getId() {
		return id;
	}

	public String getPetId() {
		return petId;
	}

	public void setPetId(String petId) {
		this.petId = petId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getShipDate() {
		return shipDate;
	}

	public void setShipDate(LocalDateTime shipDate) {
		this.shipDate = shipDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Boolean getComplete() {
		return complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}
}
