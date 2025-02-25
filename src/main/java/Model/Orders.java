package Model;

/**
 * Clasa Orders reprezintă o comandă care include un ID unic al comenzii, ID-ul clientului, ID-ul produsului și cantitatea comandată.
 *
 *  @author Maria-Alexandra Buzila, 30226
 *  @since May 2024
 */
public class Orders {

    /**
     * id reprezintă identificatorul unic al comenzii.
     */
    private int id;

    /**
     * id_c reprezintă identificatorul unic al clientului care a plasat comanda.
     */
    private int id_c;

    /**
     * id_p reprezintă identificatorul unic al produsului comandat.
     */
    private int id_p;

    /**
     * cantitate_o reprezintă cantitatea de produse comandate.
     */
    private int cantitate_o;

    /**
     * Constructorul cu parametri initializează o nouă comandă cu valorile specificate.
     *
     * @param id          Identificatorul unic al comenzii.
     * @param id_c        Identificatorul unic al clientului.
     * @param id_p        Identificatorul unic al produsului.
     * @param cantitate_o Cantitatea de produse comandate.
     */
    public Orders(int id, int id_c, int id_p, int cantitate_o) {
        this.id = id;
        this.id_c = id_c;
        this.id_p = id_p;
        this.cantitate_o = cantitate_o;
    }

    /**
     * Constructorul cu parametri initializează o nouă comandă fără ID-ul specificat.
     *
     * @param id_c        Identificatorul unic al clientului.
     * @param id_p        Identificatorul unic al produsului.
     * @param cantitate_o Cantitatea de produse comandate.
     */
    public Orders(int id_c, int id_p, int cantitate_o) {
        this.id_c = id_c;
        this.id_p = id_p;
        this.cantitate_o = cantitate_o;
    }

    /**
     * Constructorul fără parametri initializează o nouă comandă.
     */
    public Orders() {}

    /**
     * Returnează identificatorul unic al comenzii.
     *
     * @return ID-ul comenzii.
     */
    public int getId() {
        return id;
    }

    /**
     * Setează identificatorul unic al comenzii.
     *
     * @param id ID-ul nou al comenzii.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returnează identificatorul unic al clientului care a plasat comanda.
     *
     * @return ID-ul clientului.
     */
    public int getId_c() {
        return id_c;
    }

    /**
     * Setează identificatorul unic al clientului care a plasat comanda.
     *
     * @param id_c ID-ul nou al clientului.
     */
    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    /**
     * Returnează identificatorul unic al produsului comandat.
     *
     * @return ID-ul produsului.
     */
    public int getId_p() {
        return id_p;
    }

    /**
     * Setează identificatorul unic al produsului comandat.
     *
     * @param id_p ID-ul nou al produsului.
     */
    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    /**
     * Returnează cantitatea de produse comandate.
     *
     * @return Cantitatea de produse comandate.
     */
    public int getCantitate_o() {
        return cantitate_o;
    }

    /**
     * Setează cantitatea de produse comandate.
     *
     * @param cantitate_o Noua cantitate de produse comandate.
     */
    public void setCantitate_o(int cantitate_o) {
        this.cantitate_o = cantitate_o;
    }
}
