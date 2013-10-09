package br.com.siscom.sysnorte.action.util;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;

/**
 *
 * @author William Cadore
 */
public class Utils {
    
    public static void setFormatedField(JFormattedTextField jft, String format_jtf, char ch) {
        try {
            jft.setFormatterFactory(null);
            javax.swing.text.MaskFormatter format = new javax.swing.text.MaskFormatter(format_jtf);
            format.setPlaceholderCharacter(ch);
            jft.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(format));
            jft.setValue(null);
        } catch (ParseException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
