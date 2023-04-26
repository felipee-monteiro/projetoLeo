/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author fm320
 */
public class PassValidator extends InputVerifier {

    final JComponent pass;

    @Override
    public boolean shouldYieldFocus(JComponent input) {
        return true;
    }

    public PassValidator(JComponent pass) {
        this.pass = pass;
    }

    @Override
    public boolean verify(JComponent input) {
        JTextField passInput = (JTextField) input;
        String userPass = passInput.getText();

        if (userPass.isBlank()) {
            JOptionPane.showMessageDialog(null, "Senha Obrigatória.");
            pass.putClientProperty("JComponent.outline", "error");
        } else {
            pass.putClientProperty("JComponent.outline", "");
        }

        return userPass.isBlank();
    }
}
