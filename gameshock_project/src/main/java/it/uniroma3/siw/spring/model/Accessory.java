package it.uniroma3.siw.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Accessory extends Item {

	@NonNull
	private String color;

	private Category category;

	@ManyToMany(mappedBy="accessories")
	private List<Platform> platforms;

	@ManyToMany(mappedBy="accessories")
	private List<Amministrator> amministrators;

	public Accessory(String code,String name,String description,String color) {
		super(code,name,description);
		this.color = color;
	}
}
