package Presentation;

import BusinessLogic.*;
import Model.Client;
import Model.Orders;
import Model.Product;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class DeleteView extends JFrame {

    private String tipView;
    private JFrame frame;
    private JButton deleteButton = new JButton("Delete");
    private JButton backButton = new JButton("Back");
    private int selected = -1;
    private Color bgColor =new Color(51, 204, 255, 50);
    private Color bgColorButton = new Color(172, 148, 215, 255);
    private JTable clientTable;
    private JTable productTable;
    private JTable orderTable;

    public DeleteView(String tipView) {
         this.tipView = tipView;
         frame = new JFrame("Delete " + tipView);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(800, 600);
         JPanel panel = new JPanel();
         panel.setBackground(bgColor);
         if(tipView.equals("clients")){
             clientTable = new JTable();
             ClientBLL clientBLL = new ClientBLL();
             clientBLL.populateTable(clientTable);
             panel.add(new JScrollPane(clientTable));
         }else if(tipView.equals("products")) {
              productTable = new JTable();
                ProductBLL productBLL = new ProductBLL();
                productBLL.populateTable(productTable);
             panel.add(new JScrollPane(productTable));
         }else if(tipView.equals("orders")) {
              orderTable = new JTable();
                OrdersBLL ordersBLL = new OrdersBLL();
                ordersBLL.populateTable(orderTable);
             panel.add(new JScrollPane(orderTable));
         }

         JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
            deleteButton.setBackground(bgColorButton);
            backButton.setBackground(bgColorButton);
            buttonPanel.add(deleteButton);
            buttonPanel.add(backButton);
            buttonPanel.setBackground(bgColor);
            frame.add(panel);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setVisible(true);

    }

    public void addDeleteListener(ActionListener e){
        deleteButton.addActionListener(e);
    }

    public void addBackListener(ActionListener e){
        backButton.addActionListener(e);
    }

    public void disposeFrame(){
        frame.dispose();
    }

    public String getTipView(){
        return tipView;
    }

    public void addSelectionListener(ListSelectionListener e){
        if(tipView.equals("clients")){
            clientTable.getSelectionModel().addListSelectionListener(e);
        }else if(tipView.equals("products")) {
            productTable.getSelectionModel().addListSelectionListener(e);
        }else if(tipView.equals("orders")) {
            orderTable.getSelectionModel().addListSelectionListener(e);
        }
    }

    public Object getSelectedRowData(int columnIndex, JTable table) {
        int selectedRow = table.getSelectedRow();
        return table.getValueAt(selectedRow, columnIndex);
    }

    public JTable getTable(){
        if(tipView.equals("clients")){
            return clientTable;
        }else if(tipView.equals("products")) {
            return productTable;
        }else if(tipView.equals("orders")) {
            return orderTable;
        }
        return null;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public void displayErrorMessage(String s) {
        JOptionPane.showMessageDialog(this, s);
    }
}
