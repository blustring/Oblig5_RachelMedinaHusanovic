package View;

import Controller.AnimalController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateElephants extends JFrame implements ActionListener {
    private AnimalController animalController;
    private JLabel title;
    private JButton homeButton;
    private JButton updateButton;
    private JComboBox listOfElephants;

    UpdateElephants(AnimalController animalController){
        this.animalController = animalController;
        this.setTitle("Update Elephant");
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLayout(null);
        homeButton = new JButton("Dashboard");
        homeButton.setBounds(50, 30, 100, 30);
        title = new JLabel("Update Elephant");
        title.setBounds(240,10,200,25);

        String listOfElephantsValues[]= new String[animalController.getElephants().size()];

        for (int i=0; i< animalController.getElephants().size();i++){
            listOfElephantsValues[i] = animalController.getElephants().get(i).getId() + " - "
                    + animalController.getElephants().get(i).getName();
        }
        listOfElephants =new JComboBox(listOfElephantsValues);
        listOfElephants.setBounds(200,70,200,30);
        updateButton = new JButton("Update");
        updateButton.setBounds(220, 140, 100, 30);
        this.add(homeButton);
        this.add(updateButton);
        homeButton.addActionListener(this);
        updateButton.addActionListener(this);
        this.add(title);
        this.add(listOfElephants);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(homeButton)){
            this.dispose();
            Dashboard dashboard = new Dashboard(animalController);
        }else if(e.getSource().equals(updateButton)){
            this.dispose();

            String option = listOfElephants.getSelectedItem().toString();
            int id = Integer.parseInt(option.split(" ")[0]);

            UpdateElephantForm updateElephantForm = new UpdateElephantForm(animalController, id);


        }
    }
}
