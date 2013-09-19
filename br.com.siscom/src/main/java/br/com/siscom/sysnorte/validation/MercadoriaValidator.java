package br.com.siscom.sysnorte.validation;

import static javax.validation.Validation.buildDefaultValidatorFactory;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Component;

import br.com.siscom.sysnorte.model.Mercadoria;

/**
 * Implementa componente para validar os dados da entidade <code>Mercadoria</code>.
 * 
 * <p>A validação ocorre através do Bean Validations, mecanismo de validação padrão do Java baseado em anotações.</p>
 * 
 * @author YaW Tecnologia
 */
@Component
public class MercadoriaValidator implements Validator<Mercadoria> {
	
	private static ValidatorFactory factory;
	
	static {
		factory = buildDefaultValidatorFactory();
	}

	public String validate(Mercadoria m) {
		StringBuilder sb = new StringBuilder();
		if (m != null) {
			javax.validation.Validator validator = factory.getValidator();
			Set<ConstraintViolation<Mercadoria>> constraintViolations = validator.validate(m);
			
			if (!constraintViolations.isEmpty()) {
				sb.append("Validação da entidade Mercadoria\n");
				for (ConstraintViolation<Mercadoria> constraint: constraintViolations) {
					sb.append(String.format("%n%s: %s", constraint.getPropertyPath(), constraint.getMessage()));
				}
			}
		}
		return sb.toString();
	}

}
