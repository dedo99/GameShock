package it.uniroma3.siw.spring.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
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
public class Videogame extends Item {

	@Column(nullable=false)
	@Exclude
	private LocalDate dateRelease;

	@NonNull
	@Exclude
	private Genre genre;

	@NonNull
	@Exclude
	private Integer pegi;

	@NonNull
	@Exclude
	private String publisher;
	
	@Exclude
	@ManyToMany(mappedBy="videogames")
	private List<Platform> platforms;

	@Exclude
	@ManyToMany(mappedBy="videogames")
	private List<Amministrator> amministrators;
}
