package com.Instapart.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "offer")
public class Offer {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@OneToOne
	@JoinColumn(name="offer_part_id", referencedColumnName = "id")
	Part part;
	
	Integer userId;
	
	@Column(name = "price")
	Double price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	


	
	public Integer getUserId() {
		return userId;
	}

	public void setUserid(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", part=" + part + ", userId=" + userId + ", price=" + price + "]";
	}

	

	

	public Offer() {
		super();
	}
	
	
}
