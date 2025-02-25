package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clasa `EmployeeView` reprezintă interfața grafică pentru vizualizarea angajatului.
 * Configurează butoanele pentru gestionarea clienților, produselor, comenzilor și facturilor.
 * Butonul de `Back to login` permite întoarcerea la fereastra de login.
 *  @author Maria-Alexandra Buzila, 30226
 *  @since May 2024
 */
public class EmployeeView {

    private JButton clientsButton = new JButton("Clients");
    private JButton productsButton = new JButton("Products");
    private JButton ordersButton = new JButton("Orders");
    private JButton billButton = new JButton("Bills");
    private JFrame frame;
    private JButton backButton = new JButton("Back to login");
    private Color bgColor =new Color(51, 204, 255, 50);
    private Color bgColorButton = new Color(172, 148, 215, 255);

    /**
     * Constructorul clasei `EmployeeView` configurează fereastra principală și adaugă butoanele într-un layout `GridBagLayout`.
     */
    public EmployeeView() {
        this.frame = new JFrame("Employee view");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 300);

        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        clientsButton.setBackground(bgColorButton);
        productsButton.setBackground(bgColorButton);
        ordersButton.setBackground(bgColorButton);
        billButton.setBackground(bgColorButton);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(clientsButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(productsButton, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(ordersButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(billButton, gbc);

        panel.setBackground(bgColor);
        frame.add(panel);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.add(backButton);
        frame.add(panel2, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    /**
     * Adaugă un ascultător de acțiuni pentru butonul de clienți.
     * @param e ascultătorul de acțiuni de adăugat
     */
    public void addClientsListener(ActionListener e) {
        clientsButton.addActionListener(e);
    }

    /**
     * Adaugă un ascultător de acțiuni pentru butonul de produse.
     * @param e ascultătorul de acțiuni de adăugat
     */
    public void addProductsListener(ActionListener e){
        productsButton.addActionListener(e);
    }

    /**
     * Adaugă un ascultător de acțiuni pentru butonul de comenzi.
     * @param e ascultătorul de acțiuni de adăugat
     */
    public void addOrdersListener(ActionListener e){
        ordersButton.addActionListener(e);
    }

    /**
     * Adaugă un ascultător de acțiuni pentru butonul de întoarcere la login.
     * @param e ascultătorul de acțiuni de adăugat
     */
    public void addBackListener(ActionListener e){
        backButton.addActionListener(e);
    }

    /**
     * Adaugă un ascultător de acțiuni pentru butonul de facturi.
     * @param e ascultătorul de acțiuni de adăugat
     */
    public void addBillListener(ActionListener e){
        billButton.addActionListener(e);
    }

    /**
     * Închide fereastra principală.
     */
    public void disposeFrame() {
        frame.dispose();
    }
}
