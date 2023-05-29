/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordgenerator;

/**
 *
 * @author onurd
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PasswordGeneratorGUI extends AdvancedPasswordGenerator  {
  public static void main(String[] args) {
    // Create the main window
    JFrame frame = new JFrame("Advanced Password Generator");
    frame.setSize(400, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a panel for the widgets
    JPanel panel = new JPanel();
    frame.add(panel);

    // Create a label and a text field for the password
    JLabel passwordLabel = new JLabel("Password: ");
    panel.add(passwordLabel);
    JTextField passwordField = new JTextField(20);
    panel.add(passwordField);

    // Create a button for generating a new password
    JButton generateButton = new JButton("Generate");
    panel.add(generateButton);

    // Add an action listener to the button
    generateButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Generate a random password
        SecureRandom random = new SecureRandom();
        Random rnd = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 16; i++) {
          int r = rnd.nextInt(4);
          switch (r) {
            case 0:
              password.append(LOWERCASE_ALPHABET.charAt(random.nextInt(LOWERCASE_ALPHABET.length())));
              break;
            case 1:
              password.append(UPPERCASE_ALPHABET.charAt(random.nextInt(UPPERCASE_ALPHABET.length())));
              break;
            case 2:
              password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
              break;
            case 3:
              password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
              break;
          }
        }
        String passwordStr = password.toString();

        // Update the password field with the new password
        passwordField.setText(passwordStr);
      }
    });

    // Show the window
    frame.setVisible(true);
  }
}


