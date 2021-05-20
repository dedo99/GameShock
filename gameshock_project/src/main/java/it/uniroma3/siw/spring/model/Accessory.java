package it.uniroma3.siw.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Accessory extends Item {

	@NonNull
	@Exclude
	private String color;

	@NonNull
	@Exclude
	private Category category;

	@Exclude
	@ManyToMany(mappedBy="accessories")
	private List<Platform> platforms;

	@Exclude
	@ManyToMany(mappedBy="accessories")
	private List<Amministrator> amministrators;
}
