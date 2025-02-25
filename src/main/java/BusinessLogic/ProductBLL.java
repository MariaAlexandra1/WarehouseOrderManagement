package BusinessLogic;
import BusinessLogic.validators.*;
import DataAccess.ProductDAO;
import Model.Product;

import javax.swing.*;
import java.util.NoSuchElementException;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa ProductBLL gestionează operațiunile de business logic pentru entitatea Product.
 * Aceasta include validarea și interacțiunea cu baza de date prin intermediul ProductDAO.
 *
 * @author Maria-Alexandra Buzila, 30226
 * @since May 2024
 */
public class ProductBLL {

    private ProductDAO productDAO;
    private List<Validator<Product>> validators;

    /**
     * Constructorul inițializează lista de validatori și obiectul DAO pentru produse.
     */
    public ProductBLL() {
        productDAO = new ProductDAO();
        validators = new ArrayList<Validator<Product>>();
        validators.add(new PriceValidator());
        validators.add(new QuantityValidator());
    }

    /**
     * Găsește un produs după ID.
     *
     * @param id ID-ul produsului căutat
     * @return Produsul găsit
     * @throws NoSuchElementException dacă produsul nu este găsit
     */
    public Product findProductById(int id) {
        Product product = productDAO.findById(id);
        if (product == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return product;
    }

    /**
     * Inserează un produs nou în baza de date după validarea acestuia.
     *
     * @param product Produsul de inserat
     */
    public void insertProduct(Product product) {
        for (Validator<Product> v : validators) {
            v.validate(product);
        }
        productDAO.insert(product);
    }

    /**
     * Șterge un produs din baza de date.
     *
     * @param product Produsul de șters
     */
    public void deleteProduct(Product product) {
        productDAO.delete(product);
    }

    /**
     * Actualizează un produs existent în baza de date după validarea acestuia.
     *
     * @param product Produsul de actualizat
     */
    public void updateProduct(Product product) {
        for (Validator<Product> v : validators) {
            v.validate(product);
        }
        productDAO.update(product);
    }

    /**
     * Populează un JTable cu datele produselor.
     *
     * @param table JTable-ul de populat
     */
    public void populateTable(JTable table) {
        productDAO.populateTable(table);
    }
}
