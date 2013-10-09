package br.com.siscom.sysnorte.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.joda.time.DateTime;

@Entity
@Table(name = "CAD_CLIENTES")
public class Cliente implements Serializable {

	private static final long serialVersionUID = -5541523429922363033L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100)
	private String nome;
	
	@Column(length = 10)
	private String tipo_de_documento;
	
	@Column(length = 25)
	private String documento;
	
	@Column(length = 25)
	private String ie;
	
	@Column(length = 25)
	private String ie_SUFRAMA;
	
	private boolean isento_ICMS;
	
	@Column(length = 50)
	private String email_principal;
	
	@Column(length = 50)
	private String email_secundario;
	
	@Column(length = 50)
	private String endereco;
	
	@Column(length = 10)
	private String numero;
	
	@Column(length = 20)
	private String complemento;
	
	@Column(length = 20)
	private String bairro;
	
	@Column(length = 15)
	private String cep;
	
	private int pais;
	
	private int uf;
	
	private int city;
	
	@Column(length = 20)
	private String telefone_principal;
	
	@Column(length = 20)
	private String telefone;
	
	private DateTime criado_em;
	
	private DateTime editado_em;
	
	private boolean inativo;
	
	private DateTime inativo_em;
	
	private BigDecimal limite_de_credito;
	
	/** Atributo utilizado para controle <code>lock</code> (otimista) da <code>JPA</code> para cada registro (objeto) Cliente. */
	@Version
	private Integer version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo_de_documento() {
		return tipo_de_documento;
	}

	public void setTipo_de_documento(String tipo_de_documento) {
		this.tipo_de_documento = tipo_de_documento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getIe_SUFRAMA() {
		return ie_SUFRAMA;
	}

	public void setIe_SUFRAMA(String ie_SUFRAMA) {
		this.ie_SUFRAMA = ie_SUFRAMA;
	}

	public boolean isIsento_ICMS() {
		return isento_ICMS;
	}

	public void setIsento_ICMS(boolean isento_ICMS) {
		this.isento_ICMS = isento_ICMS;
	}

	public String getEmail_principal() {
		return email_principal;
	}

	public void setEmail_principal(String email_principal) {
		this.email_principal = email_principal;
	}

	public String getEmail_secundario() {
		return email_secundario;
	}

	public void setEmail_secundario(String email_secundario) {
		this.email_secundario = email_secundario;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getPais() {
		return pais;
	}

	public void setPais(int pais) {
		this.pais = pais;
	}

	public int getUf() {
		return uf;
	}

	public void setUf(int uf) {
		this.uf = uf;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public String getTelefone_principal() {
		return telefone_principal;
	}

	public void setTelefone_principal(String telefone_principal) {
		this.telefone_principal = telefone_principal;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public DateTime getCriado_em() {
		return criado_em;
	}

	public void setCriado_em(DateTime criado_em) {
		this.criado_em = criado_em;
	}

	public DateTime getEditado_em() {
		return editado_em;
	}

	public void setEditado_em(DateTime editado_em) {
		this.editado_em = editado_em;
	}

	public boolean isInativo() {
		return inativo;
	}

	public void setInativo(boolean inativo) {
		this.inativo = inativo;
	}

	public DateTime getInativo_em() {
		return inativo_em;
	}

	public void setInativo_em(DateTime inativo_em) {
		this.inativo_em = inativo_em;
	}

	public BigDecimal getLimite_de_credito() {
		return limite_de_credito;
	}

	public void setLimite_de_credito(BigDecimal limite_de_credito) {
		this.limite_de_credito = limite_de_credito;
	}
}