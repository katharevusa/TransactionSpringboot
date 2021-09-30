package com.transaction.springboottransaction.models;
import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private @NotNull String title;
	private @NotNull BigDecimal price;
	
	@Column(name="description",length=1000000)
	private @NotNull String description;
	private @NotNull String image;
	private @NotNull Integer qty;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
	@JsonIgnore
	private Category category;

	public Product() {
		
	}

	public Product(String title, BigDecimal price,String description, String image,
			Integer qty, Category category) {
		super();
		this.title = title;
		this.price = price;
		this.description = description;
		this.image = image;
		this.qty = qty;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	 @Override
	    public String toString() {
	        return "Product{" +
	                "id=" + id +
	                ", title='" + title + '\'' +
	                ", price='" + price + '\'' +
	                ", description='" + description +
	                ", image='" + image +
	                ", qty='" + qty +
	                ", category id='" + category.getId() + '\'' +
	                '}';
	    }
	
}
