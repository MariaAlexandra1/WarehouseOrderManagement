package DataAccess;

import Model.Bill;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import Connection.ConnectionFactory;


/**
 * Clasa BillDAO este responsabilă pentru accesul la datele tabelului Bill din baza de date și manipularea acestora.
 * Extinde clasa AbstractDAO pentru a beneficia de operația insert definită în aceasta.
 * Această clasă oferă metode pentru a găsi toate înregistrările din tabel și pentru a popula un tabel Swing JTable
 * cu datele obținute din baza de date.
 *
 * @author Maria-Alexandra Buzila, 30226
 * @since May 2024
 */
public class BillDAO extends AbstractDAO<Bill> {

    /**
     * Creează o listă de obiecte Bill din rezultatul unui ResultSet.
     *
     * @param resultSet Rezultatul interogării SQL.
     * @return Lista de obiecte Bill create din rezultatul interogării SQL.
     */
    private List<Bill> createObjectsB(ResultSet resultSet) {
        List<Bill> list = new ArrayList<Bill>();
        try {
            while (resultSet.next()) {
                Bill instance = new Bill(resultSet.getString("client"), resultSet.getString("product"), resultSet.getInt("cantitate"), resultSet.getDouble("pret"));
                list.add(instance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Găsește toate înregistrările din tabelul Bill.
     *
     * @return O listă de obiecte Bill care reprezintă toate înregistrările din tabel.
     */
    public List<Bill> findAllB() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM Bill";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return createObjectsB(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "BillDAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Populează un tabel Swing JTable cu datele din tabelul Bill.
     *
     * @param table JTable-ul care va fi populat cu datele din tabelul Bill.
     */
    public void populateTableB(JTable table) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Client");
        model.addColumn("Product");
        model.addColumn("Cantitate");
        model.addColumn("Pret");
        List<Bill> bills = findAllB();
        for (Bill bill : bills) {
            Object[] row = new Object[4];
            row[0] = bill.client();
            row[1] = bill.product();
            row[2] = bill.cantitate();
            row[3] = bill.pret();
            model.addRow(row);
        }
        table.setModel(model);
    }
}


