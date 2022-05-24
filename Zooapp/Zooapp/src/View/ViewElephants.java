package View;

import Controller.AnimalController;
import model.Elephant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class ViewElephants extends JFrame implements ActionListener {
    private JLabel title;
    private JButton homeButton;

    private JTable table;
    private DefaultTableModel tableModel;

    private AnimalController animalController;

    ViewElephants(AnimalController animalController){
        this.animalController = animalController;

        this.setTitle("View Elephants");
        this.setSize(1000, 600);
        this.setResizable(false);
        this.setLayout(null);

        homeButton = new JButton("Dashboard");
        homeButton.setBounds(50, 30, 100, 30);

        title = new JLabel("View Elephants");
        title.setBounds(240,10,200,25);

        String col[] = {"ID","NAME","GENDER", "COLOUR", "DOB", "DOA", "EXHIBITS", "FURRY", "WEIGHT", "HEIGHT"};

        tableModel = new DefaultTableModel(col, 0);

        Object columnNames[] = {"ID","NAME","GENDER", "COLOUR", "DOB", "DOA", "EXHIBITS", "FURRY", "WEIGHT", "HEIGHT"};

        tableModel.addRow(columnNames);

        // The 0 argument is number rows.

        for (int i=0;i<animalController.getElephants().size();i++){
            Elephant elephant = animalController.getElephants().get(i);


            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
            String DOB = dateFormat. format(elephant.getDateOfBirth());

            String DOA = dateFormat. format(elephant.getDateOfArrival());

            Object[] data = {
                    elephant.getId(),
                    elephant.getName(),
                    elephant.getGender(),
                    elephant.getColour(),
                    DOB,
                    DOA,
                    elephant.getExhibitionNumb(),
                    elephant.isFurry(),
                    elephant.getWeight(),
                    elephant.getHeight()};
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
