package br.com.siscom.sysnorte.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PERSONS_CUSTOMERS")
@DiscriminatorValue("2")
public class Customer extends Person {

	private static final long serialVersionUID = -4133580183371647600L;

	@Column(length = 50)
	private String email;

	@Column(length = 100)
	private String address;

	@Column(length = 20)
	private String phone;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}