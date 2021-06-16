package it.uniroma3.siw.spring.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public abstract class Item {

	@Id
	private String code;
	
	@Exclude
	private String name;
	
	@Exclude
	@Column(length = 2500)
	private String description;
	
	@Exclude
	private Float rating;
	
	@Exclude
	private Float newPrice;
	
	@Exclude
	private Float usedPrice;
	
	@Exclude
	@Lob
	private String image;
}
