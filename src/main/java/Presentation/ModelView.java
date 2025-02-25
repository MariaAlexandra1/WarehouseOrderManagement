package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ModelView {

    private JButton addButton = new JButton("Add");
    private JButton deleteButton = new JButton("Delete");
    private JButton updateButton = new JButton("Update");
    private JButton viewButton = new JButton("View");
    private JButton backButton = new JButton("Back to main menu");
    private JFrame frame;
    Font f1 = new Font("SansSerif", Font.BOLD, 20);
    Font outputFont=new Font("TimesNewRoman", Font.PLAIN, 15);
    Font f2 = new Font("SansSerif", Font.PLAIN, 15);
    Color bgColor =new Color(51, 204, 255, 50);
    Color bgColorButton = new Color(172, 148, 215, 255);
    private final String tipView;

    public ModelView(String tipView) {
        this.tipView = tipView;
        if (tipView.equals("clients")) {
            this.frame = new JFrame("Clients");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(300, 300);
        } else if (tipView.equals("products")) {
            this.frame = new JFrame("Products");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(300, 300);
        } else if (tipView.equals("orders")) {
            this.frame = new JFrame("Orders");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(300, 300);
        }

        JPanel panel = new JPanel();
        addButton.setBackground(bgColorButton);
        deleteButton.setBackground(bgColorButton);
        updateButton.setBackground(bgColorButton);
        viewButton.setBackground(bgColorButton);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(addButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(deleteButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(updateButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(viewButton, gbc);
        panel.setBackground(bgColor);
        frame.add(panel);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.add(backButton);
        frame.add(panel2, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void addAddListener(ActionListener e) {
        addButton.addActionListener(e);
    }

    public void addDeleteListener(ActionListener e) {
        deleteButton.addActionListener(e);
    }

    public void addUpdateListener(ActionListener e) {
        updateButton.addActionListener(e);
    }

    public void addViewListener(ActionListener e) {
        viewButton.addActionListener(e);
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

}
