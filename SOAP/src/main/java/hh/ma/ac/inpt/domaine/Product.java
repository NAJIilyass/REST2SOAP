package hh.ma.ac.inpt.domaine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {

	private long id;
	private String name;
	private double price;

	// Default constructor
	public Product() {
	}

	// Parameterized constructor for deserialization
	@JsonCreator
	public Product(@JsonProperty("id") long id, @JsonProperty("name") String name, @JsonProperty("price") double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	

}
