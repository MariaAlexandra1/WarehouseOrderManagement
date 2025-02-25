package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Update2View extends JFrame {

    private String tipView;
    private JFrame frame;
    private int selected = -1;
    private JTextField tf12 = new JTextField();
    private JTextField tf13 = new JTextField();
    private JTextField tf14 = new JTextField();

    private JTextField tf22 = new JTextField();
    private JTextField tf23 = new JTextField();
    private JTextField tf24 = new JTextField();

    private JTextField tf32 = new JTextField();
    private JTextField tf33 = new JTextField();
    private JTextField tf34 = new JTextField();

    private JLabel label2 = new JLabel("Nume: ");
    private JLabel label3 = new JLabel("Adresa: ");
    private JLabel label4 = new JLabel("Email: ");

    private JLabel label6 = new JLabel("Denumire: ");
    private JLabel label7 = new JLabel("Pret: ");
    private JLabel label8 = new JLabel("Cantitate: ");

    private JLabel label10 = new JLabel("ID Produs: ");
    private JLabel label11 = new JLabel("ID Client: ");
    private JLabel label12 = new JLabel("Cantitate: ");

    private JButton updateButton = new JButton("Update");
    private JButton backButton = new JButton("Back");
    private Color bgColor =new Color(51, 204, 255, 50);
    private Color bgColorButton = new Color(172, 148, 215, 255);

    public Update2View(String tipView, int selected) {
        this.tipView = tipView;
        this.selected = selected;
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        updateButton.setBackground(bgColorButton);
        backButton.setBackground(bgColorButton);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        if (tipView.equals("clients")) {
            this.frame = new JFrame("Add client");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(300, 300);

            layout.setHorizontalGroup(
                    layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(label2)
                                    .addComponent(label3)
                                    .addComponent(label4)
                                    .addComponent(updateButton)
                            )
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(tf12)
                                    .addComponent(tf13)
                                    .addComponent(tf14)
                                    .addComponent(backButton)
                            )
            );

            layout.setVerticalGroup(
                    layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label2)
                                    .addComponent(tf12)
                            )
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label3)
                                    .addComponent(tf13)
                            )
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label4)
                                    .addComponent(tf14)
                            )
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(updateButton)
                                    .addComponent(backButton)
                            )
            );

        } else if (tipView.equals("products")) {
            this.frame = new JFrame("Add product");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(300, 300);

            layout.setHorizontalGroup(
                    layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(label6)
                                    .addComponent(label7)
                                    .addComponent(label8)
                                    .addComponent(updateButton)
                            )
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(tf22)
                                    .addComponent(tf23)
                                    .addComponent(tf24)
                                    .addComponent(backButton)
                            )
            );

            layout.setVerticalGroup(
                    layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label6)
                                    .addComponent(tf22)
                            )
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label7)
                                    .addComponent(tf23)
                            )
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label8)
                                    .addComponent(tf24)
                            )
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(updateButton)
                                    .addComponent(backButton)
                            )
            );
        } else if (tipView.equals("orders")) {
            this.frame = new JFrame("Add order");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(300, 300);

            layout.setHorizontalGroup(
                    layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(label10)
                                    .addComponent(label11)
                                    .addComponent(label12)
                                    .addComponent(updateButton)
                            )
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(tf32)
                                    .addComponent(tf33)
                                    .addComponent(tf34)
                                    .addComponent(backButton)
                            )
            );

            layout.setVerticalGroup(
                    layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label10)
                                    .addComponent(tf32)
                            )
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label11)
                                    .addComponent(tf33)
                            )
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label12)
                                    .addComponent(tf34)
                            )
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(updateButton)
                                    .addComponent(backButton)
                            )
            );
        }
        panel.setBackground(bgColor);
        frame.add(panel);
        frame.setVisible(true);
    }

    public void addUpdateListener(ActionListener e) {
        updateButton.addActionListener(e);
    }

    public void addBackListener(ActionListener e) {
        backButton.addActionListener(e);
    }

    public void disposeFrame() {
        frame.dispose();
    }

    public String getTipView() {
        return tipView;
    }


    public String getTf12() {
        return tf12.getText();
    }

    public String getTf13() {
        return tf13.getText();
    }

    public String getTf14() {
        return tf14.getText();
    }


    public String getTf22() {
        return tf22.getText();
    }

    public String getTf23() {
        return tf23.getText();
    }

    public String getTf24() {
        return tf24.getText();
    }


    public String getTf32() {
        return tf32.getText();
    }

    public String getTf33() {
        return tf33.getText();
    }

    public String getTf34() {
        return tf34.getText();
    }

    public int getSelected() {
        return selected;
    }

    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
