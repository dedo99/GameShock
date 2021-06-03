package it.uniroma3.siw.spring.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
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
	@ManyToOne
	private Platform platforms;

}
