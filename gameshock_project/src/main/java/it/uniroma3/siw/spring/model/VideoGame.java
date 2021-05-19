package it.uniroma3.siw.spring.model;

import java.time.LocalDate;
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
public class VideoGame extends Item{

	private LocalDate dateRelease;

	@NonNull
	private Genre genre;

	private Integer pegi;

	private String publisher;
	
	@ManyToMany(mappedBy="videogames")
	private List<Platform> platforms;

	@ManyToMany(mappedBy="videogames")
	private List<Amministrator> amministrators;

	public VideoGame(String code,String name,String description,Genre genre) {
		super(code,name,description);
		this.genre = genre;
	}
}
