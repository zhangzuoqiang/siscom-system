package br.com.siscom.sysnorte.model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Classe de modelo que representa uma mercadoria.
 * 
 * <p>A <code>mercadoria</code> � um objeto persistido no banco de dados, por isso a classificamos como <strong>Entidade</strong>.</p>
 * 
 * <p>Por se tratar de uma Entidade persistente, a <code>Mercadoria</code> utiliza as anota��es <code>JPA</code> para definir o mapeamento <code>ORM</code>.
 * 
 * <p>As funcionalidades desse sistema demonstração são concentradas no cadastro (CRUD) de mercadorias.</p>
 * 
 * <p>
 *  A classe <code>AbstractPersistable</code> (Spring Data JPA) define uma estrutura com ID da entidade, m�todo equals e hashcode.
 *  O objetivo em <i>enxugar</i> o mapeamento JPA. 
 * </p>
 * 
 * <p>
 *  Outra caracter�stica dessa classe, � o uso de anota��es do Bean Validations para validar o estado (dados) da <code>Mercadoria</code>.
 *  Bean Validations (JSR 303) � uma especifica��o Java para habilitar a valida��o de dados via o uso de anota��es. O principal provider
 *  dessa API � o <code>Hibernate Validator</code>.
 * </p>
 * 
 * @author YaW Tecnologia
 */
@Entity
@Table(name="mercadoria")
public class Mercadoria extends AbstractPersistable<Integer> {
	
	@NotNull @Size(min=5, max=200)
	private String nome;
	
	private String descricao;
	
	@NotNull @Min(value=1)
	private Integer quantidade;
	
	@NotNull @Min(value=1)
	private Double preco;
	
	/** Atributo utilizado para controle <code>lock</code> (otimista) da <code>JPA</code> para cada registro (objeto) Mercadoria. */
	@Version
	private Integer version;
	
	private static final NumberFormat numberFmt = NumberFormat.getNumberInstance(new Locale("pt","BR"));
	
	public Mercadoria(){
	}
	
	public Mercadoria(Integer id, String nome, String descricao, Integer quantidade, Double preco, Integer version) {
		setId(id);
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.version = version;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public String getPrecoFormatado() {
		return convertPrecoToString(this.preco);
	}
	
	public Integer getVersion() {
		return version;
	}
	
	public static String convertPrecoToString(double preco) {
		return numberFmt.format(preco);
	}
	
	public static double formatStringToPreco(String strPreco) throws ParseException {
		 return numberFmt.parse(strPreco).doubleValue();
	}
	
}
