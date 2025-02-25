package Presentation;



import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientController {

    private ClientView clientView;

    public ClientController(ClientView clientView) {
        this.clientView = clientView;

        clientView.addBackToLoginListener(new BackToLoginListener());
        clientView.addProductsSelectionListener(new SelectionListenerP());
        clientView.addSelectClientListener(new SelectClientListener());


    }

    public class BackToLoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.disposeFrame();
            View view = new View();
            Controller controller = new Controller(view);
        }
    }

    public class SelectionListenerP implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                Object selectedData = clientView.getSelectedRowData(0, clientView.getProductsTable());
                clientView.setSelectedProduct((int) selectedData);

            }
        }
    }

    public class SelectClientListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(clientView.getSelectedProduct() == -1) {
                clientView.displayErrorMessage("Please select a product");
            }else{
                clientView.disposeFrame();
                Clients2View clients2View = new Clients2View();
                Clients2Controller clients2Controller = new Clients2Controller(clients2View);
                clients2View.setSelectedProduct(clientView.getSelectedProduct());
            }
        }
    }
}
