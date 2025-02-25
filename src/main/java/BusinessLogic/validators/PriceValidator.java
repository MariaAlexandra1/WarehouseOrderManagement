package BusinessLogic.validators;

import Model.Product;

/**
 * Clasa PriceValidator implementează interfața Validator pentru obiecte de tip Product.
 * Validează prețul unui produs asigurându-se că este pozitiv.
 *
 * @author Maria-Alexandra Buzila, 30226
 * @since May 2024
 */
public class PriceValidator implements Validator<Product> {

    /**
     * Metoda validate verifică dacă prețul unui produs este valid (mai mare sau egal cu zero).
     *
     * @param t obiectul Product de validat
     * @throws IllegalArgumentException dacă prețul produsului nu este valid
     */
    public void validate(Product t) {
        if (t.getPret() <= 0) {
            throw new IllegalArgumentException("The price limit is not respected!");
        }
    }
}
