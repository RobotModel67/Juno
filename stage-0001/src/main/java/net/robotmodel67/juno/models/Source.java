package net.robotmodel67.juno.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SOURCES")
public class Source {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String Name;
	private String Description;
	private long legacyId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public long getLegacyId() {
		return legacyId;
	}
	public void setLegacyId(long legacyId) {
		this.legacyId = legacyId;
	}
	
	
	
}
