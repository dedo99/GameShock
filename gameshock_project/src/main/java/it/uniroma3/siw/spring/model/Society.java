package it.uniroma3.siw.spring.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Society {

	@Id
	@NonNull
	private String name;

	@NonNull
	private LocalDate foundationDate;

	@Column(nullable=false)
	private String foundationPlace;

	@OneToMany(mappedBy="society")
	private List<Platform> platforms;

	public Society(String name, LocalDate foundationDate, String foundationPlace) {
		this.name = name;
		this.foundationDate = foundationDate;
		this.foundationPlace = foundationPlace;
		this.platforms = new ArrayList<Platform>();
	}
}
