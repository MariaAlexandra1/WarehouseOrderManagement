package BusinessLogic;

import DataAccess.OrderDAO;
import BusinessLogic.validators.Validator;
import Model.Orders;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clasa OrdersBLL gestionează operațiunile de business logic pentru entitatea Orders.
 * Aceasta include validarea și interacțiunea cu baza de date prin intermediul OrderDAO.
 *
 * @author Maria-Alexandra Buzila, 30226
 * @since May 2024
 */
public class OrdersBLL {

    private OrderDAO ordersDAO;
    private List<Validator<Orders>> validators;

    /**
     * Constructorul inițializează lista de validatori și obiectul DAO pentru comenzi.
     */
    public OrdersBLL() {
        ordersDAO = new OrderDAO();
        validators = new ArrayList<Validator<Orders>>();
    }

    /**
     * Găsește o comandă după ID.
     *
     * @param id ID-ul comenzii căutate
     * @return Comanda găsită
     * @throws IllegalArgumentException dacă comanda nu este găsită
     */
    public Orders findOrderById(int id) {
        Orders order = ordersDAO.findById(id);
        if (order == null) {
            throw new IllegalArgumentException("The order with id =" + id + " was not found!");
        }
        return order;
    }

    /**
     * Inserează o comandă nouă în baza de date după validarea acesteia.
     *
     * @param order Comanda de inserat
     */
    public void insertOrder(Orders order) {
        for (Validator<Orders> v : validators) {
            v.validate(order);
        }
        ordersDAO.insert(order);
    }

    /**
     * Șterge o comandă din baza de date.
     *
     * @param order Comanda de șters
     */
    public void deleteOrder(Orders order) {
        ordersDAO.delete(order);
    }

    /**
     * Actualizează o comandă existentă în baza de date după validarea acesteia.
     *
     * @param order Comanda de actualizat
     */
    public void updateOrder(Orders order) {
        for (Validator<Orders> v : validators) {
            v.validate(order);
        }
        ordersDAO.update(order);
    }

    /**
     * Găsește toate comenzile din baza de date.
     *
     * @return Lista comenzilor
     * @throws IllegalArgumentException dacă nu există comenzi în baza de date
     */
    public List<Orders> findAllOrders() {
        List<Orders> orders = ordersDAO.findAll();
        if (orders == null) {
            throw new IllegalArgumentException("There are no orders in the database!");
        }
        return orders;
    }

    /**
     * Șterge o comandă din baza de date.
     *
     * @param order Comanda de șters
     */
    public void delete(Orders order) {
        ordersDAO.delete(order);
    }

    /**
     * Populează un JTable cu datele comenzilor.
     *
     * @param table JTable-ul de populat
     */
    public void populateTable(JTable table) {
        ordersDAO.populateTable(table);
    }
}
