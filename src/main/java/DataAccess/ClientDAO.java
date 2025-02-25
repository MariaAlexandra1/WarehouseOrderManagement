package DataAccess;

import Model.*;

/**
 * Clasa ClientDAO este responsabilă pentru accesul la datele tabelului Client din baza de date și manipularea acestora.
 * Extinde clasa AbstractDAO pentru a beneficia de operațiile CRUD (Create, Read, Update, Delete) generice.
 * Această clasă nu adaugă metode suplimentare față de cele moștenite din AbstractDAO, dar specifică tipul generic ca fiind Client.
 *
 * @author Maria-Alexandra Buzila, 30226
 * @since May 2024
 */
public class ClientDAO extends AbstractDAO<Client> {
}
