package com.transaction.springboottransaction.models;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	private @NotNull String title;

	private @NotNull String description;

	private @NotNull String image;
}
