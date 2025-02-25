package Presentation;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import BusinessLogic.*;

/**
 * Clasa `UpdateView` reprezintă interfața grafică pentru actualizarea datelor din tabelele client, produs și comandă.
 * Extinde JFrame și configurează vizualizarea în funcție de tipul de date (clients, products, orders).
 *  @author Maria-Alexandra Buzila, 30226
 *  @since May 2024
 */
public class UpdateView extends JFrame {

    private String tipView;
    private JFrame frame;
    private JButton updateButton = new JButton("Update");
    private JButton backButton = new JButton("Back");
    private Color bgColor = new Color(51, 204, 255, 50);
    private Color bgColorButton = new Color(172, 148, 215, 255);
    private JTable clientTable;
    private JTable productTable;
    private JTable orderTable;
    private int selected = -1;

    /**
     * Constructorul `UpdateView` inițializează fereastra de actualizare și configurează panourile și tabelele.
     * @param tipView tipul de date (clients, products, orders) pentru care se va face actualizarea
     */
    public UpdateView(String tipView) {
        this.tipView = tipView;
        frame = new JFrame("Update " + tipView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        JPanel panel = new JPanel();
        panel.setBackground(bgColor);

        if (tipView.equals("clients")) {
            clientTable = new JTable();
            ClientBLL clientBLL = new ClientBLL();
            clientBLL.populateTable(clientTable);
            panel.add(new JScrollPane(clientTable));
        } else if (tipView.equals("products")) {
            productTable = new JTable();
            ProductBLL productBLL = new ProductBLL();
            productBLL.populateTable(productTable);
            panel.add(new JScrollPane(productTable));
        } else if (tipView.equals("orders")) {
            orderTable = new JTable();
            OrdersBLL ordersBLL = new OrdersBLL();
            ordersBLL.populateTable(orderTable);
            panel.add(new JScrollPane(orderTable));
        }

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        updateButton.setBackground(bgColorButton);
        backButton.setBackground(bgColorButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(backButton);
        buttonPanel.setBackground(bgColor);
        frame.add(panel);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    /**
     * Adaugă un ascultător pentru butonul de actualizare.
     * @param e ascultătorul pentru acțiunea de actualizare
     */
    public void addUpdateListener(ActionListener e) {
        updateButton.addActionListener(e);
    }

    /**
     * Adaugă un ascultător pentru butonul de întoarcere.
     * @param e ascultătorul pentru acțiunea de întoarcere
     */
    public void addBackListener(ActionListener e) {
        backButton.addActionListener(e);
    }

    /**
     * Adaugă un ascultător pentru selecția din tabel.
     * @param e ascultătorul pentru evenimentele de selecție
     */
    public void addSelectionListener(ListSelectionListener e) {
        if (tipView.equals("clients")) {
            clientTable.getSelectionModel().addListSelectionListener(e);
        } else if (tipView.equals("products")) {
            productTable.getSelectionModel().addListSelectionListener(e);
        } else if (tipView.equals("orders")) {
            orderTable.getSelectionModel().addListSelectionListener(e);
        }
    }

    /**
     * Închide fereastra curentă.
     */
    public void disposeFrame() {
        frame.dispose();
    }

    /**
     * Returnează tipul de vizualizare.
     * @return tipul de vizualizare (clients, products, orders)
     */
    public String getTipView() {
        return tipView;
    }

    /**
     * Returnează datele din rândul selectat al tabelului.
     * @param columnIndex indexul coloanei pentru care se obțin datele
     * @param table tabelul din care se obțin datele
     * @return datele din rândul selectat
     */
    public Object getSelectedRowData(int columnIndex, JTable table) {
        int selectedRow = table.getSelectedRow();
        return table.getValueAt(selectedRow, columnIndex);
    }

    /**
     * Returnează tabelul specific tipului de vizualizare.
     * @return tabelul curent
     */
    public JTable getTable() {
        if (tipView.equals("clients")) {
            return clientTable;
        } else if (tipView.equals("products")) {
            return productTable;
        } else if (tipView.equals("orders")) {
            return orderTable;
        }
        return null;
    }

    /**
     * Returnează indexul rândului selectat.
     * @return indexul rândului selectat
     */
    public int getSelected() {
        return selected;
    }

    /**
     * Setează indexul rândului selectat.
     * @param selected indexul rândului selectat
     */
    public void setSelected(int selected) {
        this.selected = selected;
    }

    /**
     * Afișează un mesaj de eroare.
     * @param s mesajul de eroare de afișat
     */
    public void displayErrorMessage(String s) {
        JOptionPane.showMessageDialog(this, s);
    }
}
