package Presentation;

import BusinessLogic.*;
import Model.Client;
import Model.Product;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class Clients2View extends JFrame {

        private JTable clientsTable;
        private JButton backButton;
        private JTextField cantitateField;
        private JLabel cantitateLabel;
        private int selectedClient = -1;
        private int selectedProduct = -1;
        private JButton orderButton;


        Color bgColor =new Color(51, 204, 255, 50);
        Color bgColorButton = new Color(172, 148, 215, 255);
        Color bgColorPanel = new Color(209, 175, 175, 255);
        private JFrame frame;

        public Clients2View() {
            this.frame = new JFrame("Client View");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            JPanel panel = new JPanel();
            BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
            panel.setLayout(layout);

            clientsTable = new JTable();
            ClientBLL clientBLL = new ClientBLL();
            clientBLL.populateTable(clientsTable);
            panel.add(new JScrollPane(clientsTable));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
            backButton = new JButton("Back to login");
            orderButton = new JButton("Order");
            backButton.setBackground(bgColorButton);
            orderButton.setBackground(bgColorButton);
            buttonPanel.add(backButton);
            buttonPanel.add(orderButton);
            buttonPanel.setBackground(bgColor);

            frame.add(panel);


            JPanel cantitatePanel = new JPanel();
            cantitatePanel.setLayout(new BoxLayout(cantitatePanel, BoxLayout.X_AXIS));
            cantitateLabel = new JLabel("Cantitate: ");
            cantitateField = new JTextField();
            cantitatePanel.add(cantitateLabel);
            cantitatePanel.add(cantitateField);
            cantitatePanel.setBackground(bgColor);

            JPanel panel3 = new JPanel();
            panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
            panel3.add(buttonPanel);
            panel3.add(cantitatePanel);
            frame.add(panel3, BorderLayout.SOUTH);



            frame.setVisible(true);
        }


        public void addBackListener(ActionListener e) {
            backButton.addActionListener(e);
        }

        public Object getSelectedRowData(int columnIndex, JTable table) {
            int selectedRow = table.getSelectedRow();
            return table.getValueAt(selectedRow, columnIndex);
        }

        public void addOrderListener(ActionListener e) {
            orderButton.addActionListener(e);
        }

        public int getSelectedClient() {
            return selectedClient;
        }

        public void setSelectedClient(int selectedClient) {
            this.selectedClient = selectedClient;
        }

        public void addClientsSelectionListener(ListSelectionListener e) {
            clientsTable.getSelectionModel().addListSelectionListener(e);
        }

        public JTable getClientsTable() {
            return clientsTable;
        }

        public void disposeFrame() {
            frame.dispose();
        }

        public void displayErrorMessage(String s) {
            JOptionPane.showMessageDialog(this, s);
        }

        public String getCantitateField() {
            return cantitateField.getText();
        }

        public int getSelectedProduct() {
            return selectedProduct;
        }

        public void setSelectedProduct(int selectedProduct) {
            this.selectedProduct = selectedProduct;
        }
}


