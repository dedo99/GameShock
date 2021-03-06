package it.uniroma3.siw.spring.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
public class Society {

	@Id
	@NonNull
	private String name;

	@Exclude
	@NonNull
	private LocalDate foundationDate;

	@Exclude
	@Column(nullable=false)
	private String foundationPlace;

	@Exclude
	@OneToMany(mappedBy="society")
	private List<Platform> platforms;
}
