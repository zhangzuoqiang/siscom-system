package br.com.siscom.sysnorte.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;

@Entity
@Table(name="LOG_ESTOQUE_MERCADORIAS")
public class EstoqueMercadoriaLog implements Serializable {

	private static final long serialVersionUID = 513548496275899161L;
	
	
	
	@Temporal(TemporalType.DATE)
	private DateTime data_operacao;
	
	@ManyToOne
	private EstoqueMercadoria mercadoria;
	
	@ManyToOne
	private UsuarioDoSistema usuario;

}
