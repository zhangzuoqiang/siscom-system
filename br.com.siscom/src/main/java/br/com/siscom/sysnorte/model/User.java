package br.com.siscom.sysnorte.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PERSONS_USERS")
@DiscriminatorValue("1")
public class User extends Person {

	private static final long serialVersionUID = -4368329943963391882L;

	@Column(length = 20, nullable = false)
	private String login;

	@Column(length = 20, nullable = false)
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}