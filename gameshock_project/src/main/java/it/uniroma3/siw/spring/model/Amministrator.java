package it.uniroma3.siw.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
public class Amministrator {

	@Id
	@NonNull
	private String email;
	
	@NonNull
	@Exclude
	private String username;
	
	@NonNull
	@Exclude
	private String password;
	
	@Exclude
	@ManyToMany
	private List<VideoGame> videogames;
	
	@Exclude
	@ManyToMany
	private List<Accessory> accessories;
}
