package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModelController {

    private ModelView modelView;

    public ModelController(ModelView modelView){
        this.modelView = modelView;
        modelView.addBackListener(new BackListener());
        modelView.addAddListener(new AddListener());
        modelView.addDeleteListener(new DeleteListener());
        modelView.addUpdateListener(new UpdateListener());
        modelView.addViewListener(new ViewListener());
    }

    public class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            modelView.disposeFrame();
            EmployeeView employeeView = new EmployeeView();
            EmployeeController employeeController = new EmployeeController(employeeView);
        }
    }

    public class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            modelView.disposeFrame();
            String tip = modelView.getTipView();
            AddView addView = new AddView(tip);
            AddController addController = new AddController(addView);
        }
    }

    public class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            modelView.disposeFrame();
            String tip = modelView.getTipView();
            DeleteView deleteView = new DeleteView(tip);
            DeleteController deleteController = new DeleteController(deleteView);
        }
    }

    public class UpdateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            modelView.disposeFrame();
            String tip = modelView.getTipView();
            UpdateView updateView = new UpdateView(tip);
            UpdateController updateController = new UpdateController(updateView);
        }
    }

    public class ViewListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            modelView.disposeFrame();
            String tip = modelView.getTipView();
            TableView tableView = new TableView(tip);
            TableController tableController = new TableController(tableView);
        }
    }


}
