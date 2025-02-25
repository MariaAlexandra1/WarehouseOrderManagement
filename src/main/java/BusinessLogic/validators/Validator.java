package BusinessLogic.validators;

/**
 * Interfața Validator definește metoda de validare pentru obiectele de tip generic T.
 * Această interfață este utilizată pentru a asigura că obiectele respectă anumite reguli de validare.
 *
 * @param <T> tipul obiectului care urmează să fie validat
 * @author Maria-Alexandra Buzila, 30226
 * @since May 2024
 */
public interface Validator<T> {

        /**
         * Metoda de validare care trebuie implementată pentru a verifica dacă un obiect de tip T este valid.
         *
         * @param t obiectul de validat
         */
        public void validate(T t);
}
