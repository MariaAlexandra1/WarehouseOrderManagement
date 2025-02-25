package Presentation;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clasa `UpdateController` gestionează logica pentru vizualizarea de actualizare.
 * Configurează ascultătorii pentru butoane și selecțiile din tabel.
 *  @author Maria-Alexandra Buzila, 30226
 *  @since May 2024
 */
public class UpdateController {

    private UpdateView updateView;

    /**
     * Constructorul `UpdateController` inițializează vizualizarea și adaugă ascultători pentru toate butoanele și selecțiile.
     * @param updateView instanța de `UpdateView` pentru interfața grafică
     */
    public UpdateController(UpdateView updateView) {
        this.updateView = updateView;
        updateView.addBackListener(new BackListener());
        updateView.addUpdateListener(new UpdateListener());
        updateView.addSelectionListener(new SelectionListener());
    }

    /**
     * Ascultător pentru butonul de întoarcere. Închide fereastra curentă și deschide fereastra anterioară.
     */
    public class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateView.disposeFrame();
            ModelView modelView = new ModelView(updateView.getTipView());
            ModelController modelController = new ModelController(modelView);
        }
    }

    /**
     * Ascultător pentru butonul de actualizare. Verifică dacă este selectat un rând și deschide fereastra de actualizare detaliată.
     */
    public class UpdateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String tip = updateView.getTipView();
            int id = updateView.getSelected();
            if (id == -1) {
                updateView.displayErrorMessage("Please select a row to update");
            } else {
                updateView.disposeFrame();
                Update2View update2View = new Update2View(tip, id);
                Update2Controller update2Controller = new Update2Controller(update2View);
            }
        }
    }

    /**
     * Ascultător pentru selecțiile din tabel. Actualizează indexul rândului selectat în vizualizare.
     */
    public class SelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                Object selectedData = updateView.getSelectedRowData(0, updateView.getTable());
                updateView.setSelected((int) selectedData);
            }
        }
    }
}
