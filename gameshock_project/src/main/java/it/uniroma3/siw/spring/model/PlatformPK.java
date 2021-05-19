package it.uniroma3.siw.spring.model;

import java.io.Serializable;

public class PlatformPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String version;

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() + this.version.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		PlatformPK p = (PlatformPK) obj;
		return this.getName().equals(p.getName()) && this.getVersion().equals(p.getVersion());
	}
	
	

}
