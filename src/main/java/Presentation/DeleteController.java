package Presentation;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BusinessLogic.*;
import Model.*;

public class DeleteController {

    private DeleteView deleteView;

    public DeleteController(DeleteView deleteView){
        this.deleteView = deleteView;
        String tip = deleteView.getTipView();

        deleteView.addBackListener(new BackListener());
        deleteView.addDeleteListener(new DeleteListener());

        deleteView.addSelectionListener(new SelectionListener());
    }

    public class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deleteView.disposeFrame();
            ModelView modelView = new ModelView(deleteView.getTipView());
            ModelController modelController = new ModelController(modelView);
        }
    }

    public class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String tip = deleteView.getTipView();
            if (deleteView.getSelected() == -1) {
                deleteView.displayErrorMessage("Please select a row to delete");
                return;
            } else {
                if (tip.equals("clients")) {
                    int id = deleteView.getSelected();
                    try{
                    ClientBLL clientBLL = new ClientBLL();
                    Client client = new Client(id, "", "", "");
                    clientBLL.deleteClient(client);
                    }catch(Exception ex){
                        deleteView.displayErrorMessage(ex.getMessage());
                    }
                    deleteView.disposeFrame();
                    TableView tableView = new TableView("clients");
                    TableController tableController = new TableController(tableView);
                }else if(tip.equals("products")) {
                    int id = deleteView.getSelected();
                    try {
                        ProductBLL productBLL = new ProductBLL();
                        Product product = new Product(id, "", 0, 0);
                        productBLL.deleteProduct(product);
                    }catch (Exception ex){
                        deleteView.displayErrorMessage(ex.getMessage());
                    }
                    deleteView.disposeFrame();
                    TableView tableView = new TableView("products");
                    TableController tableController = new TableController(tableView);
                }else if(tip.equals("orders")) {
                    int id = deleteView.getSelected();
                    try {
                        OrdersBLL ordersBLL = new OrdersBLL();
                        Orders order = new Orders(id, 0, 0, 0);
                        ordersBLL.delete(order);
                    }catch (Exception ex){
                        deleteView.displayErrorMessage(ex.getMessage());
                    }
                    deleteView.disposeFrame();
                    TableView tableView = new TableView("orders");
                    TableController tableController = new TableController(tableView);
                }
            }
        }
    }

    public class SelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                Object selectedData = deleteView.getSelectedRowData(0, deleteView.getTable());
                deleteView.setSelected((int) selectedData);
            }
        }
    }
}
