package it.uniroma3.siw.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
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
	
	@ManyToMany
	private List<VideoGame> videogames;
	
	@ManyToMany
	private List<Accessory> accessories;

	public Amministrator(String email, String username, String password) {
		this.email = email;
		this.username = username;
		this.password = password;
	}
}
