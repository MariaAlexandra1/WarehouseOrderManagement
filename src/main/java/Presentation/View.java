package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clasa `View` reprezintă interfața grafică pentru selectarea tipului de utilizator (client sau angajat).
 * Aceasta configurează o fereastră principală cu două butoane, unul pentru client și unul pentru angajat.
 * De asemenea, permite adăugarea de ascultători de acțiuni pentru fiecare buton.
 *
 * *  @author Maria-Alexandra Buzila, 30226
 *  *  @since May 2024
 */
public class View {

    private JButton clientButton = new JButton("Client   ");
    private JButton employeeButton = new JButton("Employee");
    Color bgColor =new Color(51, 204, 255, 50);
    Color bgColorButton = new Color(172, 148, 215, 255);
    private JFrame frame;

    /**
     * Constructorul clasei `View` configurează fereastra principală și adaugă butoanele într-un layout `GridBagLayout`.
     */
    public View() {
        this.frame = new JFrame("Select user type");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 300);

        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(clientButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(employeeButton, gbc);

        panel.add(clientButton);
        clientButton.setBackground(bgColorButton);
        employeeButton.setBackground(bgColorButton);
        panel.add(employeeButton);
        panel.setBackground(bgColor);
        frame.add(panel);

        frame.setVisible(true);
    }

    /**
     * Adaugă un ascultător de acțiuni pentru butonul de client.
     * @param actionListener ascultătorul de acțiuni de adăugat
     */
    public void addClientListener(ActionListener actionListener) {
        clientButton.addActionListener(actionListener);
    }

    /**
     * Adaugă un ascultător de acțiuni pentru butonul de angajat.
     * @param actionListener ascultătorul de acțiuni de adăugat
     */
    public void addEmployeeListener(ActionListener actionListener) {
        employeeButton.addActionListener(actionListener);
    }

    /**
     * Închide fereastra principală.
     */
    public void disposeFrame() {
        frame.dispose();
    }
}
