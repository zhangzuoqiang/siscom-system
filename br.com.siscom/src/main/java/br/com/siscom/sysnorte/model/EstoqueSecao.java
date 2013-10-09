package br.com.siscom.sysnorte.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CAD_ESTOQUE_SECOES")
public class EstoqueSecao implements Serializable {

	private static final long serialVersionUID = 6411962998532257958L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String nome_da_secao;
	
	@OneToMany(mappedBy="secao")
	private List<EstoqueMercadoria> estoques_fiscal;

}
