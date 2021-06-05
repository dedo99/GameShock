package it.uniroma3.siw.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class Videogame extends Item {

	@Column(nullable=false)
	@Exclude
	private String releaseDate;

	@Exclude
	@Enumerated(EnumType.STRING)
	private Genre genre;

	@Exclude
	private Integer pegi;

	@Exclude
	private String publisher;
	
	@Exclude
	@ManyToOne
	private Platform platform;

}
