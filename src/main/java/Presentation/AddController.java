package Presentation;

import BusinessLogic.*;
import Model.Client;
import Model.Orders;
import Model.Product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddController {

    private AddView addView;

    public AddController(AddView addView){
        this.addView = addView;
        String tip = addView.getTipView();
        addView.addBackListener(new BackListener());
        addView.addAddListener(new AddListener());
    }

    public class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addView.disposeFrame();
            ModelView modelView = new ModelView(addView.getTipView());
            ModelController modelController = new ModelController(modelView);
        }
    }

    public class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String tip = addView.getTipView();
            if(tip.equals("clients"))
            {
                int id = -1;
                String nume = addView.getTf12();
                String adresa = addView.getTf13();
                String email = addView.getTf14();
                id = Integer.parseInt(addView.getTf11());
                try {

                    System.out.println(id);
                    ClientBLL clientBLL = new ClientBLL();
                    Client client = new Client(id, nume, adresa, email);
                    System.out.println(client);
                    clientBLL.insertClient(client);
                }catch (Exception ex){
                    addView.displayErrorMessage(ex.getMessage());
                }

            }
            else if(tip.equals("products"))
            {
                String denumire = addView.getTf22();
                int id = -1;
                double pret = -1;
                int stoc = -1;
                try {
                     id = Integer.parseInt(addView.getTf21());
                     pret = Double.parseDouble(addView.getTf23());
                     stoc = Integer.parseInt(addView.getTf24());
                }catch (Exception ex) {
                    addView.displayErrorMessage("Id, pret and stoc must be integers");
                }
                try {
                    ProductBLL productBLL = new ProductBLL();
                    Product product = new Product(id, denumire, pret, stoc);
                    productBLL.insertProduct(product);
                }catch (Exception ex){
                    addView.displayErrorMessage(ex.getMessage());
                }

            }
            else if(tip.equals("orders"))
            {
                int id = -1;
                int idClient = -1;
                int idProduct = -1;
                int cantitate = -1;
                try {
                    id = Integer.parseInt(addView.getTf31());
                    idClient = Integer.parseInt(addView.getTf32());
                    idProduct = Integer.parseInt(addView.getTf33());
                    cantitate = Integer.parseInt(addView.getTf34());
                    if(id == -1 || idClient == -1 || idProduct == -1 || cantitate == -1)
                        addView.displayErrorMessage("Id, idClient, idProduct and cantitate must be integers");

                    ClientBLL clientBLL = new ClientBLL();
                    Client client = clientBLL.findClientById(idClient);
                    ProductBLL productBLL = new ProductBLL();
                    Product product = productBLL.findProductById(idProduct);
                    if (client == null || product == null)
                        addView.displayErrorMessage("Client or product does not exist");

                    OrdersBLL orderBLL = new OrdersBLL();
                    Orders order = new Orders(id, idClient, idProduct, cantitate);
                    if(orderBLL.findOrderById(id) != null)
                        addView.displayErrorMessage("Order already exists");
                    orderBLL.insertOrder(order);
                }catch (Exception ex){
                    addView.displayErrorMessage(ex.getMessage());
                }

            }
            addView.disposeFrame();

            AddView addView = new AddView(tip);
            AddController addController = new AddController(addView);
        }
    }


}
