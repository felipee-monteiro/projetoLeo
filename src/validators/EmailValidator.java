/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author fm320
 */
public class EmailValidator extends InputVerifier {
    
    final private JComponent email;
    
    @Override
    public boolean shouldYieldFocus(JComponent input) {
        return true;
    }
    
    public EmailValidator(JComponent email) {
        this.email = email;
    }
    
    @Override
    public boolean verify(JComponent input) {
        JTextField textInput = (JTextField) input;
        String userInput = textInput.getText();

        if (!userInput.isBlank()) {
            Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
            Matcher userMatcherInput = emailPattern.matcher(userInput);
            if (!userMatcherInput.matches()) {
                JOptionPane.showMessageDialog(null, "Digite um e-mail válido.");
                email.putClientProperty("JComponent.outline", "error");
            } else {
                email.putClientProperty("JComponent.outline", "");
            }
            return userMatcherInput.matches();
        }
        JOptionPane.showMessageDialog(null, "Digite um e-mail válido.");
        email.putClientProperty("JComponent.outline", "error");
        return false;
    }
}
