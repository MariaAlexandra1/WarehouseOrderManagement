package DataAccess;

import Connection.ConnectionFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clasa AbstractDAO reprezintă o clasă abstractă generică pentru operațiile CRUD (Create, Read, Update, Delete)
 * pe obiecte de tip T. Această clasă folosește reflexia pentru a interoga baza de date și a crea obiecte de tipul
 * specificat. De asemenea, oferă metode pentru inserarea, actualizarea, ștergerea și găsirea obiectelor din baza
 * de date, precum și pentru popularea unui tabel Swing JTable cu datele obținute din baza de date.
 *
 * @param <T> Tipul obiectelor cu care va opera clasa.
 * @author Maria-Alexandra Buzila, 30226
 * @since May 2024
 */
public class AbstractDAO<T> {

    /** Logger pentru înregistrarea mesajelor de avertizare și erori. */
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    /** Culorile de fundal utilizate pentru tabel. */
    Color bgColor = new Color(51, 204, 255, 50);

    /** Tipul de obiect cu care operează clasa. */
    private final Class<T> type;

    /**
     * Constructorul clasei AbstractDAO.
     * Acesta extrage tipul generic T folosit și îl reține pentru a fi utilizat în operațiile ulterioare.
     */
    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Creează interogarea SQL SELECT pentru a obține toate înregistrările din tabel.
     *
     * @param field Câmpul după care se filtrează rezultatele (de exemplu, "id").
     * @return Interogarea SQL SELECT generată.
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * Returnează o listă cu toate obiectele din tabel.
     *
     * @return Lista de obiecte recuperate din baza de date.
     */
    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM " + type.getSimpleName();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Returnează obiectul cu un anumit ID din tabel.
     *
     * @param id ID-ul obiectului căutat.
     * @return Obiectul cu ID-ul specificat sau null dacă nu este găsit.
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Creează obiecte de tip T bazate pe rezultatele interogării SQL.
     *
     * @param resultSet Rezultatele interogării SQL.
     * @return Lista de obiecte create.
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T) ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException | IllegalAccessException | SecurityException |
                 IllegalArgumentException | InvocationTargetException | SQLException | IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Inserează un nou obiect în tabel.
     *
     * @param t Obiectul de inserat în tabel.
     */
    public void insert(T t) {
        String insertStatement = "INSERT INTO " + type.getSimpleName() + " VALUES(";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(t);
                if (obj instanceof String) {
                    insertStatement += "'" + obj + "',";
                } else {
                    insertStatement += obj + ",";
                }
            }
            insertStatement = insertStatement.substring(0, insertStatement.length() - 1);
            insertStatement += ")";
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(insertStatement);

            statement.execute();
        } catch (IllegalAccessException | SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * Actualizează înregistrarea corespunzătoare unui obiect din tabel.
     *
     * @param t Obiectul cu datele actualizate care va fi actualizat în tabel.
     */
    public void update(T t) {
        String updateStatement = "UPDATE " + type.getSimpleName() + " SET ";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int id = -1;
        try {
            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(t);
                if (field.getName().equals("id")) {
                    id = (Integer) obj;
                }
                if (obj instanceof String) {
                    updateStatement += field.getName() + " = '" + obj + "',";
                } else {
                    updateStatement += field.getName() + " = " + obj + ",";
                }
            }
            updateStatement = updateStatement.substring(0, updateStatement.length() - 1);
            updateStatement += " WHERE id = ?";
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(updateStatement);
            statement.setInt(1, id);
            statement.execute();
        } catch (IllegalAccessException | SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * Șterge înregistrarea corespunzătoare unui obiect din tabel.
     *
     * @param t Obiectul care va fi șters din tabel.
     */
    public void delete(T t) {
        String deleteStatement = "DELETE FROM " + type.getSimpleName() + " WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int id = -1;
        try {
            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(t);
                if (field.getName().equals("id")) {
                    id = (Integer) obj;
                }
            }
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(deleteStatement);
            statement.setInt(1, id);
            statement.execute();
        } catch (IllegalAccessException | SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }


    /**
     * Populează un tabel JTable Swing cu datele obținute din baza de date.
     *
     * @param table Tabelul JTable care va fi populat.
     */
    public void populateTable(JTable table) {
        List<T> objects = this.findAll();

        Field[] fields = this.type.getDeclaredFields();
        String[] columns = new String[fields.length];
        for        (int i = 0; i < fields.length; i++) {
            columns[i] = fields[i].getName();
        }

        DefaultTableModel model = new DefaultTableModel(columns, 0);
        for (T object : objects) {
            Object[] row = new Object[columns.length];
            for (int i = 0; i < columns.length; i++) {
                try {
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columns[i], object.getClass());
                    Method method = propertyDescriptor.getReadMethod();
                    row[i] = method.invoke(object);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            model.addRow(row);
        }

        table.setModel(model);
        table.setBackground(bgColor);
    }
}

