package it.uniroma3.siw.spring.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@IdClass(PlatformPK.class)
public class Platform {

	@Id
	@Column(nullable=false)
	private String name;

	@Id
	@NonNull
	private String version;

	@NonNull
	private LocalDate releaseDate;

	@ManyToOne
	private Society society;
	
	@ManyToMany
	private List<VideoGame> videogames;
	
	@ManyToMany
	private List<Accessory> accessories;

	public Platform(String name, String version, LocalDate releaseDate,Society society) {
		this.name = name;
		this.version = version;
		this.releaseDate = releaseDate;
		this.society = society;
		//this.items = new ArrayList<Item>();
	}
}
