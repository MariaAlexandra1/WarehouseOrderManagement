package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clasa `Controller` gestionează interacțiunile dintre `View` și logica aplicației.
 * Configurează ascultătorii pentru butoanele de client și angajat.
 *
 *  @author Maria-Alexandra Buzila, 30226
 *  @since May 2024
 */
public class Controller {

    private View view;

    /**
     * Constructorul clasei `Controller` inițializează vizualizarea și adaugă ascultători pentru butoanele de client și angajat.
     * @param view instanța de `View` pentru interfața grafică
     */
    public Controller(View view){
        this.view = view;
        view.addClientListener(new ClientPageListener());
        view.addEmployeeListener(new EmployeePageListener());
    }

    /**
     * Ascultător pentru butonul de client. Deschide fereastra pentru client.
     */
    public class ClientPageListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.disposeFrame();
            ClientView clientView = new ClientView();
            ClientController clientController = new ClientController(clientView);
        }
    }

    /**
     * Ascultător pentru butonul de angajat. Deschide fereastra pentru angajat.
     */
    public class EmployeePageListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.disposeFrame();
            EmployeeView employeeView = new EmployeeView();
            EmployeeController employeeController = new EmployeeController(employeeView);
        }
    }
}
