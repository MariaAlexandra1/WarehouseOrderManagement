package Presentation;


import DataAccess.AbstractDAO;
import DataAccess.BillDAO;
import Model.Bill;
import Model.Client;
import Model.Orders;
import Model.Product;
import BusinessLogic.*;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clients2Controller {

       private Clients2View clients2View;

       public Clients2Controller(Clients2View clients2View) {
           this.clients2View = clients2View;

           clients2View.addBackListener(new BackListener());
           clients2View.addClientsSelectionListener(new SelectionListenerC());
           clients2View.addOrderListener(new OrderListener());
       }

        public class BackListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                clients2View.disposeFrame();
                ClientView clientView = new ClientView();
                ClientController clientController = new ClientController(clientView);
            }
        }


        public class SelectionListenerC implements ListSelectionListener {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Object selectedData = clients2View.getSelectedRowData(0, clients2View.getClientsTable());
                    clients2View.setSelectedClient((int) selectedData);

                }
            }
        }

    public class OrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(clients2View.getSelectedClient() == -1) {
                clients2View.displayErrorMessage("Please select a client");
            }else if(clients2View.getCantitateField().equals("")){
                    clients2View.displayErrorMessage("Please enter a quantity");
            }else{
                Product product = new Product();
                Client client = new Client();
                int quantityToOrder = -1;
                try {
                    ProductBLL productBLL = new ProductBLL();
                    OrdersBLL ordersBLL = new OrdersBLL();
                    Orders order = new Orders(clients2View.getSelectedClient(), clients2View.getSelectedProduct(), Integer.parseInt(clients2View.getCantitateField()));
                    quantityToOrder = Integer.parseInt(clients2View.getCantitateField());
                    int quantityInStock = productBLL.findProductById(clients2View.getSelectedProduct()).getCantitate();
                    if (quantityToOrder > quantityInStock) {
                        clients2View.displayErrorMessage("Not enough stock\n Available stock: " + quantityInStock);
                    }else if(quantityToOrder <= 0){
                        clients2View.displayErrorMessage("Please enter a valid quantity");
                    }
                    else {
                        product = new Product(clients2View.getSelectedProduct(), productBLL.findProductById(clients2View.getSelectedProduct()).getDenumire(), productBLL.findProductById(clients2View.getSelectedProduct()).getPret(), quantityInStock - quantityToOrder);
                        productBLL.updateProduct(product);
                        client = new ClientBLL().findClientById(clients2View.getSelectedClient());
                        ordersBLL.insertOrder(order);
                        Bill bill = new Bill(client.getNume(), product.getDenumire(), quantityToOrder, product.getPret() * quantityToOrder);
                        BillDAO billDAO = new BillDAO();
                        billDAO.insert(bill);
                        clients2View.disposeFrame();
                        View view = new View();
                        Controller controller = new Controller(view);
                    }
                }catch (Exception ex){
                    clients2View.displayErrorMessage(ex.getMessage());
                }



            }
        }
    }


}
