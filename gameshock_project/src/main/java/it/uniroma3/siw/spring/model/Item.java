package it.uniroma3.siw.spring.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class Item {

	@Id
	@NonNull
	private String code;
	
	@NonNull
	private String name;
	
	@NonNull
	private String description;
	
	private Float rating;
	
	private Float newPrice;
	
	private Float usedPrice;
	
	//@ManyToMany(mappedBy="items")
	//private List<Platform> platforms;
	
	//@ManyToMany(mappedBy="items")
	//private List<Amministrator> amministrators;
	
	public Item(String code, String name, String description) {
		this.code = code;
		this.name = name;
		this.description = description;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public boolean equals(Object obj) {
		Item i = (Item) obj;
		return this.getCode().equals(i.getCode());
	}
	
	@Override
	public int hashCode() {
		return this.getCode().hashCode();
	}
}
