package org.okcjug.springdatajpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "associate")
public class Associate {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	@Column(name = "first_name")
	private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
	
    public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}