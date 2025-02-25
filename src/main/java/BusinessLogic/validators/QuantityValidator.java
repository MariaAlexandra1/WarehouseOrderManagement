package BusinessLogic.validators;

import Model.Product;

/**
 * Clasa QuantityValidator implementează interfața Validator pentru obiecte de tip Product.
 * Validează cantitatea unui produs asigurându-se că este pozitivă.
 *
 * @author Maria-Alexandra Buzila, 30226
 * @since May 2024
 */
public class QuantityValidator implements Validator<Product> {

    /**
     * Metoda validate verifică dacă cantitatea unui produs este validă (mai mare sau egală cu zero).
     *
     * @param t obiectul Product de validat
     * @throws IllegalArgumentException dacă cantitatea produsului nu este validă
     */
    public void validate(Product t) {
        if (t.getCantitate() < 0) {
            throw new IllegalArgumentException("Quantity is not a valid quantity!");
        }
    }
}
