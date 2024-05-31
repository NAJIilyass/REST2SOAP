package hh.ma.ac.inpt.domaine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {

	private long id;
	private String name;
	private double price;
	private String description;
	private boolean available;
	private String category;
	@XmlElementWrapper(name = "tags")
	@XmlElement(name = "tag")
	private List<String> tags;

	// Default constructor
	public Product() {
	}

	// Parameterized constructor for deserialization
	@JsonCreator
	public Product(@JsonProperty("name") String name, @JsonProperty("price") double price,
				   @JsonProperty("description") String description, @JsonProperty("available") boolean available,
				   @JsonProperty("category") String category, @JsonProperty("tags") List<String> tags) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.available = available;
		this.category = category;
		this.tags = tags;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}


}
