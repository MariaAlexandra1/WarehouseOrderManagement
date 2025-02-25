package Model;

/**
 * Clasa Product reprezintă un produs cu un ID unic, denumire, preț și cantitate.
 *
 *  @author Maria-Alexandra Buzila, 30226
 *  @since May 2024
 */
public class Product {

    /**
     * id reprezintă identificatorul unic al produsului.
     */
    private int id;

    /**
     * denumire reprezintă denumirea produsului.
     */
    private String denumire;

    /**
     * pret reprezintă prețul produsului.
     */
    private double pret;

    /**
     * cantitate reprezintă cantitatea produsului disponibilă.
     */
    private int cantitate;

    /**
     * Constructorul cu parametri initializează un nou produs cu valorile specificate.
     *
     * @param id        Identificatorul unic al produsului.
     * @param denumire  Denumirea produsului.
     * @param pret      Prețul produsului.
     * @param cantitate Cantitatea disponibilă a produsului.
     */
    public Product(int id, String denumire, double pret, int cantitate) {
        this.id = id;
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
    }

    /**
     * Constructorul fără parametri initializează un nou produs.
     */
    public Product() {}

    /**
     * Returnează identificatorul unic al produsului.
     *
     * @return ID-ul produsului.
     */
    public int getId() {
        return id;
    }

    /**
     * Setează identificatorul unic al produsului.
     *
     * @param id ID-ul nou al produsului.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returnează denumirea produsului.
     *
     * @return Denumirea produsului.
     */
    public String getDenumire() {
        return denumire;
    }

    /**
     * Setează denumirea produsului.
     *
     * @param denumire Noua denumire a produsului.
     */
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    /**
     * Returnează prețul produsului.
     *
     * @return Prețul produsului.
     */
    public double getPret() {
        return pret;
    }

    /**
     * Setează prețul produsului.
     *
     * @param pret Noul preț al produsului.
     */
    public void setPret(double pret) {
        this.pret = pret;
    }

    /**
     * Returnează cantitatea produsului disponibilă.
     *
     * @return Cantitatea produsului disponibilă.
     */
    public int getCantitate() {
        return cantitate;
    }

    /**
     * Setează cantitatea produsului disponibilă.
     *
     * @param cantitate Noua cantitate a produsului.
     */
    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    /**
     * Suprascrie metoda toString pentru a afișa informații despre produs.
     *
     * @return O reprezentare textuală a obiectului Product.
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", denumire='" + denumire + '\'' +
                ", pret=" + pret +
                ", cantitate=" + cantitate +
                '}';
    }
}
