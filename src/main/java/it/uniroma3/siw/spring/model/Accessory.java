package it.uniroma3.siw.spring.model;

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
public class Accessory extends Item {

	@Exclude
	private String color;

	@Exclude
	@Enumerated(EnumType.STRING)
	private Category category;

	@ManyToOne
	private Platform platform;

}
