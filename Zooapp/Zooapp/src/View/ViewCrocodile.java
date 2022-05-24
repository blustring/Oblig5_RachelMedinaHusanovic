package View;

import Controller.AnimalController;
import model.Crocodile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class ViewCrocodile extends JFrame implements ActionListener {
    private JLabel title;
    private JButton homeButton;

    private JTable table;
    private DefaultTableModel tableModel;

    private AnimalController animalController;

    ViewCrocodile(AnimalController animalController) {
        this.animalController = animalController;

        this.setTitle("View Crocodiles");
        this.setSize(1000, 600);
        this.setResizable(false);
        this.setLayout(null);

        homeButton = new JButton("Dashboard");
        homeButton.setBounds(50, 30, 100, 30);

        title = new JLabel("View Crocodiles");
        title.setBounds(240,10,200,25);

        String col[] = {"ID","NAME","GENDER", "COLOUR", "Date of Birth", "Date of Arrival", "EXHIBITS", "Venom", "Number of Teeth"};

        tableModel = new DefaultTableModel(col, 0);

        Object columnNames[] = {"ID","NAME","GENDER", "COLOUR", "DOB", "DOA", "EXHIBITS","Venom", "Number of Teeth"};

        tableModel.addRow(columnNames);

        for (int i=0;i<animalController.getCrocodiles().size();i++){
            Crocodile crocodile = animalController.getCrocodiles().get(i);

            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
            String DOB = dateFormat. format(crocodile.getDateOfBirth());

            String DOA = dateFormat. format(crocodile.getDateOfArrival());

            Object[] data = {
                    crocodile.getId(),
                    crocodile.getName(),
                    crocodile.getGender(),
                    crocodile.getColour(),
                    DOB,
                    DOA,
                    crocodile.getExhibitionNumb(),
                    crocodile.getIsVennon(),
                    crocodile.getNumberOfTeeth()};
            tableModel.addRow(data);

        }

        table = new JTable(tableModel);

        table.setBounds(30,120,850,300);
        table.setBackground(Color.DARK_GRAY);
        table.setForeground(Color.white);
        table.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        this.add(table);

        this.add(title);
        this.add(homeButton);

        homeButton.addActionListener(this);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(homeButton)){
            this.dispose();
            Dashboard dashboard = new Dashboard(animalController);
        }
    }
}
