package Model;

/**
 * Clasa Bill reprezintă o factură care include numele clientului, numele produsului, cantitatea și prețul.
 * Aceasta este o înregistrare (record) care simplifică definirea unei clase de date imutabile.
 *
 * @param client    Numele clientului.
 * @param product   Numele produsului.
 * @param cantitate Cantitatea de produse facturate.
 * @param pret      Prețul total al produselor facturate.
 *
 * @author Maria-Alexandra Buzila, 30226
 * @since May 2024
 */
public record Bill(String client, String product, int cantitate, double pret) {}
