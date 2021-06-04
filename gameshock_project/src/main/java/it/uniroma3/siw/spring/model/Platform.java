package it.uniroma3.siw.spring.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"version"}))
public class Platform {

	@Id
	@Column(nullable=false)
	private String name;

	@NonNull
	private String version;

	@NonNull
	@Exclude
	private LocalDate releaseDate;

	@ManyToOne
	private Society society;
	
	@OneToMany(mappedBy = "platform")
	private List<Videogame> videogames;
	
	@OneToMany(mappedBy = "platform")
	private List<Accessory> accessories;
}
