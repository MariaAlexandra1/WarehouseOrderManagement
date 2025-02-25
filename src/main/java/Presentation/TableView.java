package Presentation;

import BusinessLogic.*;
import DataAccess.AbstractDAO;
import DataAccess.BillDAO;
import Model.Bill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TableView extends JFrame{

    private String tipView;
    private JFrame frame;
    private JButton backButton = new JButton("Back");
    private Color bgColor =new Color(51, 204, 255, 50);
    private Color bgColorButton = new Color(172, 148, 215, 255);
    private JTable clientTable;
    private JTable productTable;
    private JTable orderTable;
    private JTable billTable;

    public TableView(String tipView) {
        this.tipView = tipView;
        frame = new JFrame("Update " + tipView);
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
            OrdersBLL orderBLL = new OrdersBLL();
            orderBLL.populateTable(orderTable);
            panel.add(new JScrollPane(orderTable));
        } else if(tipView.equals("bill")) {
            billTable = new JTable();
            BillDAO billDAO = new BillDAO();
            billDAO.populateTableB(billTable);
            panel.add(new JScrollPane(billTable));
        }

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        backButton.setBackground(bgColorButton);
        buttonPanel.add(backButton);
        buttonPanel.setBackground(bgColor);
        frame.add(panel);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
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

}
