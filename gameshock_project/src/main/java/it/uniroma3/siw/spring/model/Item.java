package it.uniroma3.siw.spring.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public abstract class Item {

	@Id
	@NonNull
	private String code;
	
	@NonNull
	@Exclude
	private String name;
	
	@NonNull
	@Exclude
	private String description;
	
	@NonNull
	@Exclude
	private Float rating;
	
	@NonNull
	@Exclude
	private Float newPrice;
	
	@NonNull
	@Exclude
	private Float usedPrice;
}
