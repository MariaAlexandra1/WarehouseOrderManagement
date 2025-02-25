package DataAccess;

import Model.Product;

/**
 * Clasa ProductDAO este responsabilă pentru accesul la datele tabelului Product din baza de date și manipularea acestora.
 * Extinde clasa AbstractDAO pentru a beneficia de operațiile CRUD (Create, Read, Update, Delete) generice.
 * Această clasă nu adaugă metode suplimentare față de cele moștenite din AbstractDAO, dar specifică tipul generic ca fiind Product.
 *
 * @author Maria-Alexandra Buzila, 30226
 * @since May 2024
 */
public class ProductDAO extends AbstractDAO<Product> {
}
