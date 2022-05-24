package View;

import Controller.AnimalController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener{

    private JButton addAnimal;
    private JButton ViewAnimal;
    private JButton UpdateAnimal;
    private JButton deleteAnimal;
    private JComboBox animalsOptions;

    private JLabel title;

    AnimalController animalController;

    public Dashboard(AnimalController animalController){
        this.animalController = animalController;

        this.setTitle("DashBoard");
        this.setSize(600, 500);
        this.setResizable(false);
        this.setLayout(null);

        title = new JLabel("Animal Management System");
        title.setBounds(240,10,200,30);


        String animalsValues[]={"Elephant","Crocodile"};
        animalsOptions =new JComboBox(animalsValues);
        animalsOptions.setBounds(200,70,200,30);

        addAnimal = new JButton("Add Animal");
        addAnimal.setBounds(100,150,150,30);
        addAnimal.addActionListener(this);


        ViewAnimal = new JButton("View Animal");
        ViewAnimal.setBounds(300,150,150,30);
        ViewAnimal.addActionListener(this);


        UpdateAnimal = new JButton("Update Animal");
        UpdateAnimal.setBounds(100,250,150,30);
        UpdateAnimal.addActionListener(this);


        deleteAnimal = new JButton("Delete Animal");
        deleteAnimal.setBounds(300,250,150,30);
        deleteAnimal.addActionListener(this);

        this.add(title);
        this.add(addAnimal);
        this.add(ViewAnimal);
        this.add(UpdateAnimal);
        this.add(deleteAnimal);
        this.add(animalsOptions);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(addAnimal)){
            String selectedvalue = animalsOptions.getSelectedItem().toString();
            this.dispose();

            if (selectedvalue.equals("Elephant")){
                AddElephant addAnimal = new AddElephant(animalController);
            }else if (selectedvalue.equals("Crocodile")){
                AddCrocodile addAnimal = new AddCrocodile(animalController);
            }
        }
        else if(e.getSource().equals(ViewAnimal)){
            String selectedvalue = animalsOptions.getSelectedItem().toString();

            if (selectedvalue.equals("Elephant")){

                if (animalController.getElephants().size() == 0){
                    JOptionPane.showMessageDialog(null,
                            "There is no Elephant in record. Please add few of them first.\n");
                }else{
                    this.dispose();
                    ViewElephants viewElephants = new ViewElephants(animalController);
                }

            }else if (selectedvalue.equals("Crocodile")){
                if (animalController.getCrocodiles().size() == 0){
                    JOptionPane.showMessageDialog(null,
                            "There is no Crocodile in record. Please add few of them first.\n");
                }else{
                    this.dispose();
                    ViewCrocodile viewCrocodile = new ViewCrocodile(animalController);
                }
            }
        }
        else if(e.getSource().equals(UpdateAnimal)){

            String selectedvalue = animalsOptions.getSelectedItem().toString();

            if (selectedvalue.equals("Elephant")){

                if (animalController.getElephants().size() == 0){
                    JOptionPane.showMessageDialog(null,
                            "There is no Elephant in record. Please add few of them first.\n");
                }else{
                    this.dispose();
                    UpdateElephants updateElephants = new UpdateElephants(animalController);
                }

            }else if (selectedvalue.equals("Crocodile")){
                if (animalController.getCrocodiles().size() == 0){
                    JOptionPane.showMessageDialog(null,
                            "There is no Crocodile in record. Please add few of them first.\n");
                }else{
                    this.dispose();
                    UpdateCrocodiles updateCrocodiles = new UpdateCrocodiles(animalController);
                }
            }

        }else if (e.getSource().equals(deleteAnimal)){


            String selectedvalue = animalsOptions.getSelectedItem().toString();

            if (selectedvalue.equals("Elephant")){

                if (animalController.getElephants().size() == 0){
                    JOptionPane.showMessageDialog(null,
                            "There is no Elephant in record. Please add few of them first.\n");
                }else{
                    this.dispose();
                    DeleteElephant deleteElephant = new DeleteElephant(animalController);
                }

            }else if (selectedvalue.equals("Crocodile")){
                if (animalController.getCrocodiles().size() == 0){
                    JOptionPane.showMessageDialog(null,
                            "There is no Crocodile in record. Please add few of them first.\n");
                }else{
                    this.dispose();
                    DeleteCrocodile deleteCrocodile = new DeleteCrocodile(animalController);
                }
            }

        }
    }
}
