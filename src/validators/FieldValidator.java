 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author fm320
 */
public class FieldValidator extends InputVerifier {

    final JComponent pass;
    private String message = "";

    @Override
    public boolean shouldYieldFocus(JComponent input) {
        return true;
    }

    public FieldValidator(JComponent pass, String message) {
        this.pass = pass;
        this.message = message;
    }

    @Override
    public boolean verify(JComponent input) {
        JTextField passInput = (JTextField) input;
        String userPass = passInput.getText();

        if (userPass.isBlank()) {
            JOptionPane.showMessageDialog(null, this.message);
            pass.putClientProperty("JComponent.outline", "error");
        } else {
            pass.putClientProperty("JComponent.outline", "");
        }

        return !userPass.isBlank();
    }
}
