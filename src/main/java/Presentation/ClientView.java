package Presentation;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import BusinessLogic.ProductBLL;

import java.awt.*;
import java.awt.event.ActionListener;

public class ClientView extends JFrame {

    private JTable productsTable;

    private JButton backToLoginButton;
    private int selectedProduct = -1;


    private JButton selectClientButton;

    Font f1 = new Font("SansSerif", Font.BOLD, 20);
    Font outputFont=new Font("TimesNewRoman", Font.PLAIN, 15);
    Font f2 = new Font("SansSerif", Font.PLAIN, 15);
    Color bgColor =new Color(51, 204, 255, 50);
    Color bgColorButton = new Color(172, 148, 215, 255);
    Color bgColorPanel = new Color(209, 175, 175, 255);
    private JFrame frame;

    public ClientView() {
        this.frame = new JFrame("Client View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        productsTable = new JTable();

        ProductBLL productBLL = new ProductBLL();
        productBLL.populateTable(productsTable);
        panel.add(new JScrollPane(productsTable));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        backToLoginButton = new JButton("Back to login");
        selectClientButton = new JButton("Select client");
        backToLoginButton.setBackground(bgColorButton);
        selectClientButton.setBackground(bgColorButton);
        buttonPanel.add(backToLoginButton);
        buttonPanel.add(selectClientButton);
        buttonPanel.setBackground(bgColor);

        frame.add(panel);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }


    public void addBackToLoginListener(ActionListener e) {
        backToLoginButton.addActionListener(e);
    }

    public void addSelectClientListener(ActionListener e) {
        selectClientButton.addActionListener(e);
    }

    public Object getSelectedRowData(int columnIndex, JTable table) {
        int selectedRow = table.getSelectedRow();
        return table.getValueAt(selectedRow, columnIndex);
    }


    public int getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(int selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public void addProductsSelectionListener(ListSelectionListener e) {
        productsTable.getSelectionModel().addListSelectionListener(e);
    }


    public JTable getProductsTable() {
        return productsTable;
    }


    public void disposeFrame() {
        frame.dispose();
    }

    public void displayErrorMessage(String s) {
        JOptionPane.showMessageDialog(this, s);
    }
}
