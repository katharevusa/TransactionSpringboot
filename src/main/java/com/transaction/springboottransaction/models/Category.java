package com.transaction.springboottransaction.models;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique=true)
	private @NotNull String name;

	private @NotNull String description;

	private @NotNull String image;
	
	public Category() {
		
	}
	
	public Category(String name, String description, String image) {
		this.name = name;
		this.description = description;
		this.image = image;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", desc=" + description + ", imageURL=" + image + "]";
	}

}
