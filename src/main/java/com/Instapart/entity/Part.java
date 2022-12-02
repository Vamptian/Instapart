package com.Instapart.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="part")
public class Part {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
	
	@Column(name="is_available")
	Boolean isAvailable;
	
	@Column(name="name")
	String name;
	
	@Column(name="discription")
	String discription;
	
	@Column(name="price")
	Integer price;
	
	@OneToMany
	@JoinColumn(name="part_id", referencedColumnName = "id")
	List<Offer> offers;

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	
	@Override
	public String toString() {
		return "Part [id=" + id + ", isAvailable=" + isAvailable + ", name=" + name + ", discription=" + discription
				+ ", price=" + price + ", offers=" + offers + "]";
	}

	public Part() {
		super();
	}
	
	

}
