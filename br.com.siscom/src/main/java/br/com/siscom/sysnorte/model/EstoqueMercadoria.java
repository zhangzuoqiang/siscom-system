package br.com.siscom.sysnorte.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name="CAD_ESTOQUE_MERCADORIAS")
public class EstoqueMercadoria implements Serializable {

	private static final long serialVersionUID = -24882897170749844L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String cod_de_barras;
	
	@Column(nullable=false)
	private String cod_de_referencia;
	
	@Column(nullable=false)
	private String und_de_compra;
	
	@Column(nullable=false)
	private String und_de_venda;
	
	@Column(nullable=false)
	private int fator_de_conversao;
	
	@Column(nullable=false)
	private String descricao;
	
	@Column(nullable=false)
	private String caracteristicas;
	
	@Column(nullable=false)
	private String cod_ncm;
	
	@ManyToOne
	private EstoqueSecao secao;
	
	@Column(nullable=false)
	private int cod_cfop;
	
	
}
