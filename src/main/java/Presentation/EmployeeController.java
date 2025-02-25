package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clasa `EmployeeController` gestionează interacțiunile dintre `EmployeeView` și logica aplicației.
 * Configurează ascultătorii pentru butoanele din interfața de angajat.
 *  @author Maria-Alexandra Buzila, 30226
 *  @since May 2024
 */
public class EmployeeController {

    private EmployeeView employeeView;

    /**
     * Constructorul clasei `EmployeeController` inițializează vizualizarea și adaugă ascultători pentru toate butoanele.
     * @param employeeView instanța de `EmployeeView` pentru interfața grafică
     */
    public EmployeeController(EmployeeView employeeView){
        this.employeeView = employeeView;
        employeeView.addBackListener(new BackListener());
        employeeView.addClientsListener(new ClientsListener());
        employeeView.addProductsListener(new ProductsListener());
        employeeView.addOrdersListener(new OrdersListener());
        employeeView.addBillListener(new BillListener());
    }

    /**
     * Ascultător pentru butonul de întoarcere la login. Închide fereastra curentă și deschide fereastra de login.
     */
    public class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            employeeView.disposeFrame();
            View view = new View();
            Controller controller = new Controller(view);
        }
    }

    /**
     * Ascultător pentru butonul de clienți. Închide fereastra curentă și deschide fereastra pentru gestionarea clienților.
     */
    public class ClientsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            employeeView.disposeFrame();
            ModelView modelView = new ModelView("clients");
            ModelController modelController = new ModelController(modelView);
        }
    }

    /**
     * Ascultător pentru butonul de produse. Închide fereastra curentă și deschide fereastra pentru gestionarea produselor.
     */
    public class ProductsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            employeeView.disposeFrame();
            ModelView modelView = new ModelView("products");
            ModelController modelController = new ModelController(modelView);
        }
    }

    /**
     * Ascultător pentru butonul de comenzi. Închide fereastra curentă și deschide fereastra pentru gestionarea comenzilor.
     */
    public class OrdersListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            employeeView.disposeFrame();
            ModelView modelView = new ModelView("orders");
            ModelController modelController = new ModelController(modelView);
        }
    }

    /**
     * Ascultător pentru butonul de facturi. Închide fereastra curentă și deschide fereastra pentru gestionarea facturilor.
     */
    public class BillListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            employeeView.disposeFrame();
            TableView tableView = new TableView("bill");
            TableController tableController = new TableController(tableView);
        }
    }
}
