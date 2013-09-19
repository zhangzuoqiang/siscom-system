package br.com.siscom.sysnorte.app;

import java.util.Collection;
import java.util.Locale;
import java.util.Vector;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.SkinInfo;
import org.pushingpixels.substance.api.skin.SubstanceEmeraldDuskLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceMistAquaLookAndFeel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.siscom.sysnorte.controller.MercadoriaController;

/**
 * Ponto de entrada da aplicação.
 * 
 * @author SYSNORTE Tecnologia
 */
public class Main {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				Locale.setDefault(new Locale("pt", "BR"));
				
//				org.pushingpixels.substance.api.skin.SubstanceMistAquaLookAndFeel
				
				/*for(SkinInfo ski : new Vector<SkinInfo> ( SubstanceLookAndFeel.getAllSkins().values())) {
					System.out.println((SkinInfo)ski);
				}*/
				
				//SubstanceLookAndFeel.setSkin(new SubstanceMistAquaLookAndFeel());

				try {
					UIManager
							.setLookAndFeel(new SubstanceMistAquaLookAndFeel());
				} catch (UnsupportedLookAndFeelException e) {

					e.printStackTrace();
				}

				final ApplicationContext context = new ClassPathXmlApplicationContext(
						"META-INF/spring-config.xml");

				context.getBean(MercadoriaController.class);
			}
		});
	}
}
