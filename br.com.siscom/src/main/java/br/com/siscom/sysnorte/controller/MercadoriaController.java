package br.com.siscom.sysnorte.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.siscom.sysnorte.dao.MercadoriaDAO;
import br.com.siscom.sysnorte.event.AbstractEventListener;
import br.com.siscom.sysnorte.event.AtualizarListarMercadoriaEvent;
import br.com.siscom.sysnorte.event.DeletarMercadoriaEvent;
import br.com.siscom.sysnorte.event.IncluirMercadoriaEvent;
import br.com.siscom.sysnorte.model.Mercadoria;
import br.com.siscom.sysnorte.ui.IncluirMercadoriaFrame;
import br.com.siscom.sysnorte.ui.ListaMercadoriasFrame;
import br.com.siscom.sysnorte.validation.Validator;
import br.com.siscom.sysnorte.action.AbstractAction;
import br.com.siscom.sysnorte.action.BooleanExpression;
import br.com.siscom.sysnorte.action.ConditionalAction;
import br.com.siscom.sysnorte.controller.AbstractController;

/**
 * Define a <code>Controller</code> principal do sistema, responsável por gerir
 * a tela com a lista de <code>Mercadoria</code>.
 * 
 * <p>
 * <code>MercadoriaController</code> é mapeada como <code>@Component</code> do
 * Spring. Dessa forma uma instância de <code>MercadoriaController</code> pode
 * ser criada e gerenciada pelo Spring, favorecendo a Inversão de Controle
 * <i>(IoC)</i> e Injeção de Dependência <i>(DI)</i>.
 * </p>
 * 
 * <p>
 * Essa <code>Controller</code> depende de outros componentes da camada
 * <code>Model</code> (DAO) e <code>View</code> (telas). As dependências são
 * resolvidas pelo Spring, através da <strong>Injeção de Dependência</strong> c/
 * a anotação <code>@Autowired</code>.
 * </p>
 * 
 * @see br.com.siscom.sysnorte.controller;
 * 
 * @author YaW Tecnologia
 */
@Component
public class MercadoriaController extends AbstractController {

	@Autowired
	private ListaMercadoriasFrame listaFrame;

	@Autowired
	private IncluirMercadoriaFrame partialFrame;

	@Autowired
	private IncluirMercadoriaFrame buscaFrame;

	@Autowired
	private MercadoriaDAO dao;

	@Autowired
	private Validator<Mercadoria> validador;

	public MercadoriaController() {
	}

	/**
	 * Método executado pelo <code>Spring</code>, depois de criar a instância de
	 * <code>MercadoriaController</code>.
	 * 
	 * <p>
	 * Faz o registro das ações e tratadores de eventos.
	 * </p>
	 */
	@PostConstruct
	private void init() {
		this.listaFrame.addWindowListener(this);

		registerAction(listaFrame.getNewButton(), new AbstractAction() {
			public void action() {
				partialFrameShowForNew();
			}
		});

		registerAction(listaFrame.getRefreshButton(), new AbstractAction() {
			public void action() {
				fireEvent(new AtualizarListarMercadoriaEvent());
			}
		});

		this.listaFrame.getTable().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount() == 2) {
					Mercadoria m = listaFrame.getTable()
							.getMercadoriaSelected();
					if (m != null) {
						// partialFrame.show(m);
						partialFrame.setMercadoria(m);
						partialFrame.setTitle("Editar Mercadoria");
						partialFrame.setVisible(true);
					}
				}
			}
		});

		registerEventListener(IncluirMercadoriaEvent.class,
				new AbstractEventListener<IncluirMercadoriaEvent>() {
					public void handleEvent(IncluirMercadoriaEvent event) {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								refreshTable();
							}
						});
					}
				});

		registerEventListener(DeletarMercadoriaEvent.class,
				new AbstractEventListener<DeletarMercadoriaEvent>() {
					public void handleEvent(DeletarMercadoriaEvent event) {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								refreshTable();
							}
						});
					}
				});

		registerEventListener(AtualizarListarMercadoriaEvent.class,
				new AbstractEventListener<AtualizarListarMercadoriaEvent>() {
					public void handleEvent(AtualizarListarMercadoriaEvent event) {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								refreshTable();
							}
						});
					}
				});

		montaActionsForPartial();

		this.listaFrame.setVisible(true);
		refreshTable();

	}

	private void montaActionsForPartial() {
		registerAction(partialFrame.getCancelarButton(), new AbstractAction() {
			public void action() {
				cleanUp();
			}
		});

		registerAction(partialFrame.getSalvarButton(), ConditionalAction
				.build().addConditional(new BooleanExpression() {

					public boolean conditional() {
						Mercadoria m = partialFrame.getMercadoria();
						String msg = validador.validate(m);
						if (!"".equals(msg == null ? "" : msg)) {
							JOptionPane.showMessageDialog(partialFrame, msg,
									"Validação",
									JOptionPane.INFORMATION_MESSAGE);
							return false;
						}
						return true;
					}
				}).addAction(new AbstractAction() {
					private Mercadoria m;

					@Transactional
					@Override
					protected void action() {
						m = partialFrame.getMercadoria();
						dao.save(m);
					}

					@Override
					public void posAction() {
						cleanUp();
						fireEvent(new IncluirMercadoriaEvent(m));
						m = null;
					}
				}));

		registerAction(partialFrame.getExcluirButton(), new AbstractAction() {
			private Mercadoria m;

			@Transactional
			@Override
			protected void action() {
				m = partialFrame.getMercadoria();
				Integer id = partialFrame.getMercadoriaId();
				if (id != null) {
					dao.delete(id);
				}
			}

			public void posAction() {
				cleanUp();
				fireEvent(new DeletarMercadoriaEvent(m));
				m = null;
			}
		});
	}

	@Override
	protected void cleanUp() {
		partialFrame.setVisible(false);
		partialFrame.resetForm();

		super.cleanUp();
	}

	private void refreshTable() {
		this.listaFrame.refreshTable(this.dao.findAll());
	}

	private void partialFrameShowForNew() {
		partialFrame.setTitle("Incluir Mercadoria");
		partialFrame.setVisible(true);
	}

}
