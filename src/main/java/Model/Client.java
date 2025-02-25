package Model;

/**
 * Clasa Client reprezintă un client cu un ID unic, nume, adresă și email.
 *
 *  @author Maria-Alexandra Buzila, 30226
 *  @since May 2024
 */
public class Client {

    /**
     * id reprezintă identificatorul unic al clientului.
     */
    private int id;

    /**
     * nume reprezintă numele clientului.
     */
    private String nume;

    /**
     * adresa reprezintă adresa clientului.
     */
    private String adresa;

    /**
     * email reprezintă emailul clientului.
     */
    private String email;

    /**
     * Constructorul cu parametri initializează un nou client cu valorile specificate.
     *
     * @param id     Identificatorul unic al clientului.
     * @param nume   Numele clientului.
     * @param adresa Adresa clientului.
     * @param email  Emailul clientului.
     */
    public Client(int id, String nume, String adresa, String email){
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
        this.email = email;
    }

    /**
     * Constructorul fără parametri initializează un nou client.
     */
    public Client() {}

    /**
     * Returnează emailul clientului.
     *
     * @return Emailul clientului.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setează emailul clientului.
     *
     * @param email Emailul nou al clientului.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returnează adresa clientului.
     *
     * @return Adresa clientului.
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Setează adresa clientului.
     *
     * @param adresa Adresa nouă a clientului.
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * Returnează numele clientului.
     *
     * @return Numele clientului.
     */
    public String getNume() {
        return nume;
    }

    /**
     * Setează numele clientului.
     *
     * @param nume Numele nou al clientului.
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * Returnează identificatorul unic al clientului.
     *
     * @return ID-ul clientului.
     */
    public int getId() {
        return id;
    }

    /**
     * Setează identificatorul unic al clientului.
     *
     * @param id ID-ul nou al clientului.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Suprascrie metoda toString pentru a afișa informații despre client.
     *
     * @return O reprezentare textuală a obiectului Client.
     */
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}