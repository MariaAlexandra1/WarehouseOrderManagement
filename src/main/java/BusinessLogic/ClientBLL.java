package BusinessLogic;

import BusinessLogic.validators.*;
import Model.Client;
import DataAccess.ClientDAO;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Clasa ClientBLL gestionează operațiunile de business logic pentru entitatea Client.
 * Aceasta include validarea și interacțiunea cu baza de date prin intermediul ClientDAO.
 *
 * @author Maria-Alexandra Buzila, 30226
 * @since May 2024
 */
public class ClientBLL {

    private List<Validator<Client>> validators;
    private ClientDAO clientDAO;

    /**
     * Constructorul inițializează lista de validatori și obiectul DAO pentru clienți.
     */
    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        clientDAO = new ClientDAO();
    }

    /**
     * Găsește un client după ID.
     *
     * @param id ID-ul clientului căutat
     * @return Clientul găsit
     * @throws NoSuchElementException dacă clientul nu este găsit
     */
    public Client findClientById(int id) {
        Client client = clientDAO.findById(id);
        if (client == null) {
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }
        return client;
    }

    /**
     * Inserează un client nou în baza de date după validarea acestuia.
     *
     * @param client Clientul de inserat
     */
    public void insertClient(Client client) {
        for (Validator<Client> v : validators) {
            v.validate(client);
        }
        clientDAO.insert(client);
    }

    /**
     * Șterge un client din baza de date.
     *
     * @param client Clientul de șters
     */
    public void deleteClient(Client client) {
        clientDAO.delete(client);
    }

    /**
     * Actualizează un client existent în baza de date după validarea acestuia.
     *
     * @param client Clientul de actualizat
     */
    public void updateClient(Client client) {
        for (Validator<Client> v : validators) {
            v.validate(client);
        }
        clientDAO.update(client);
    }

    /**
     * Populează un JTable cu datele clienților.
     *
     * @param table JTable-ul de populat
     */
    public void populateTable(JTable table) {
        clientDAO.populateTable(table);
    }
}
