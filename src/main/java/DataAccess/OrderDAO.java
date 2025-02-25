package DataAccess;

import Model.Orders;

/**
 * Clasa OrderDAO este responsabilă pentru accesul la datele tabelului Orders din baza de date și manipularea acestora.
 * Extinde clasa AbstractDAO pentru a beneficia de operațiile CRUD (Create, Read, Update, Delete) generice.
 * Această clasă nu adaugă metode suplimentare față de cele moștenite din AbstractDAO, dar specifică tipul generic ca fiind Orders.
 *
 * @author Maria-Alexandra Buzila, 30226
 * @since May 2024
 */
public class OrderDAO extends AbstractDAO<Orders> {
}
