package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableController {

    private TableView tableView;

    public TableController(TableView tableView){
        this.tableView = tableView;
        tableView.addBackListener(new BackListener());
    }

    public class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(tableView.getTipView().equals("bill")) {
                tableView.disposeFrame();
                EmployeeView employeeView = new EmployeeView();
                EmployeeController employeeController = new EmployeeController(employeeView);
            }else {
                tableView.disposeFrame();
                ModelView modelView = new ModelView(tableView.getTipView());
                ModelController modelController = new ModelController(modelView);
            }
        }
    }

}
