package View;

import Controller.AnimalController;
import model.Crocodile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteCrocodile extends JFrame implements ActionListener {
    private AnimalController animalController;
    private JLabel title;
    private JButton homeButton;
    private JButton deleteButton;
    private JComboBox listOfCrocodiles;

    DeleteCrocodile(AnimalController animalController){
        this.animalController = animalController;
        this.setTitle("Delete Crocodile");
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLayout(null);

        homeButton = new JButton("Dashboard");
        homeButton.setBounds(50, 30, 100, 30);
        title = new JLabel("Delete Crocodile");
        title.setBounds(240,10,200,25);

        String listOfCrocodilesValues[]= new String[animalController.getCrocodiles().size()];

        for (int i=0; i< animalController.getCrocodiles().size();i++){
            listOfCrocodilesValues[i] = animalController.getCrocodiles().get(i).getId()
                    + " - " + animalController.getCrocodiles().get(i).getName();
        }
        listOfCrocodiles =new JComboBox(listOfCrocodilesValues);
        listOfCrocodiles.setBounds(200,70,200,30);
        deleteButton = new JButton("Delete");
        deleteButton.setBounds(220, 140, 100, 30);
        this.add(homeButton);
        this.add(deleteButton);
        homeButton.addActionListener(this);
        deleteButton.addActionListener(this);
        this.add(title);
        this.add(listOfCrocodiles);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(homeButton)){
            this.dispose();
            Dashboard dashboard = new Dashboard(animalController);
        }else if(e.getSource().equals(deleteButton)){
            this.dispose();

            String option = listOfCrocodiles.getSelectedItem().toString();
            int id = Integer.parseInt(option.split(" ")[0]);

            for (int i=0; i< animalController.getCrocodiles().size();i++){

                Crocodile crocodile = animalController.getCrocodiles().get(i);

                if (crocodile.getId() == id) {
                    animalController.getCrocodiles().remove(i);

                    JOptionPane.showMessageDialog(null, "Crocodile Deleted Successfully");

                    this.dispose(); // delete this window
                    Dashboard dashboard = new Dashboard(animalController); // create dashboard
                }
            }


        }
    }
}
