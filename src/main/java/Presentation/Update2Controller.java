package Presentation;

import BusinessLogic.ClientBLL;
import BusinessLogic.*;
import Model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Update2Controller {

    private Update2View update2View;

    public Update2Controller(Update2View update2View) {
        this.update2View = update2View;
        String tip = update2View.getTipView();
        update2View.addBackListener(new BackListener());
        update2View.addUpdateListener(new UpdateListener());
    }

    public class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            update2View.disposeFrame();
            ModelView modelView = new ModelView(update2View.getTipView());
            ModelController modelController = new ModelController(modelView);
        }
    }

    public class UpdateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String tip = update2View.getTipView();
            if (tip.equals("clients")) {
                int id = update2View.getSelected();
                String nume = update2View.getTf12();
                String adresa = update2View.getTf13();
                String email = update2View.getTf14();

                if(nume.equals("") || adresa.equals("") || email.equals("")){
                    update2View.displayErrorMessage("You must fill all the fields!");
                }
                try {
                    ClientBLL clientBLL = new ClientBLL();
                    Client client = new Client(id, nume, adresa, email);
                    clientBLL.updateClient(client);
                }catch (Exception ex){
                     update2View.displayErrorMessage(ex.getMessage());
                }

            } else if (tip.equals("products")) {
                int id = update2View.getSelected();
                String denumire = update2View.getTf22();
                double pret = -1;
                int stoc = -1;
                try {
                     pret = Double.parseDouble(update2View.getTf23());
                     stoc = Integer.parseInt(update2View.getTf24());
                }catch (NumberFormatException ex){
                    update2View.displayErrorMessage("The price and stock must be numbers!");
                }

                if(denumire.equals("") || pret == -1 || stoc == -1){
                    update2View.displayErrorMessage("You must fill all the fields!");
                }


                try{
                ProductBLL productBLL = new ProductBLL();
                Product product = new Product(id, denumire, pret, stoc);
                productBLL.updateProduct(product);
                }catch (Exception ex){
                    update2View.displayErrorMessage(ex.getMessage());
                }

            } else if (tip.equals("orders")) {
                int id = update2View.getSelected();
                int idClient = -1;
                int idProduct = -1;
                int cantitate = -1;
                try {
                     idClient = Integer.parseInt(update2View.getTf32());
                     idProduct = Integer.parseInt(update2View.getTf33());
                     cantitate = Integer.parseInt(update2View.getTf34());
                }catch (NumberFormatException ex){
                    update2View.displayErrorMessage("The client id, product id and quantity must be numbers!");
                }
                if(idClient == -1 || idProduct == -1 || cantitate == -1){
                    update2View.displayErrorMessage("You must fill all the fields!");
                }
                try {
                    ClientBLL clientBLL = new ClientBLL();
                    Client client = clientBLL.findClientById(idClient);
                    ProductBLL productBLL = new ProductBLL();
                    Product product = productBLL.findProductById(idProduct);
                }catch(Exception ex){
                    update2View.displayErrorMessage(ex.getMessage());
                }
                try {
                    OrdersBLL ordersBLL = new OrdersBLL();
                    Orders order = new Orders(id, idClient, idProduct, cantitate);
                    ordersBLL.updateOrder(order);
                }catch (Exception ex){
                    update2View.displayErrorMessage(ex.getMessage());
                }
            }
            update2View.disposeFrame();

            TableView tableView = new TableView(tip);
            TableController tableController = new TableController(tableView);
        }
    }
}
