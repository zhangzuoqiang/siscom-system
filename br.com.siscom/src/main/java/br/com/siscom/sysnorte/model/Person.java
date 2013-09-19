package br.com.siscom.sysnorte.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE", discriminatorType=DiscriminatorType.INTEGER)
public class Person implements Serializable {

	private static final long serialVersionUID = -5851705608839632061L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length = 60, nullable = false)
	private String name;

	@Temporal(TemporalType.DATE)
	private Date include_date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getInclude_date() {
		return include_date;
	}

	public void setInclude_date(Date include_date) {
		this.include_date = include_date;
	}

	
}