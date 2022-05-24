package View;

import Controller.AnimalController;
import model.Elephant;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class AddElephant extends JFrame implements ActionListener {

    private JLabel title;

    private JLabel idLabel;
    private JTextField idField;

    private JLabel nameLabel;
    private JTextField nameField;

    private JLabel genderLabel;
    private JComboBox genderComboBox;

    private JLabel colourLabel;
    private JComboBox colourComboBox;

    private JLabel DOBLabel;
    private JDatePanelImpl DOBdatePanel;
    private JDatePickerImpl DOBdatePicker;
    UtilDateModel DOBmodel;

    private JLabel DOALabel;
    private JDatePanelImpl DOAdatePanel;
    private JDatePickerImpl DOAdatePicker;
    UtilDateModel DOAmodel;

    private JLabel exhibLabel;
    private JTextField exhibField;

    private JLabel furryLabel;
    private JCheckBox furryCheckBox;

    private JLabel weightLabel;
    private JTextField weightField;

    private JLabel heightLabel;
    private JTextField heightField;

    private JButton addButton;

    private JButton homeButton;

    AnimalController animalController;

    AddElephant(AnimalController animalController){
        this.animalController = animalController;

        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        this.setTitle("Add Elephant");
        this.setSize(600, 620);
        this.setResizable(false);
        this.setLayout(null);

        homeButton = new JButton("Dashboard");
        homeButton.setBounds(50, 30, 100, 30);

        title = new JLabel("Add Elephant");
        title.setBounds(240,10,200,25);

        idLabel = new JLabel("ID");
        idLabel.setBounds(100,100,150,25);
        idField = new JTextField();
        idField.setBounds(230,100,150,25);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(100,140,150,25);
        nameField = new JTextField();
        nameField.setBounds(230,140,150,25);

        String [] genderValues= {"Male", "Female"};

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(100,180,150,25);
        genderComboBox = new JComboBox(genderValues);
        genderComboBox.setBounds(230,180,150,25);

        String colourValues[]={"Black","Grey","White","Orange"};

        colourLabel = new JLabel("Colour");
        colourLabel.setBounds(100,220,150,25);
        colourComboBox = new JComboBox(colourValues);
        colourComboBox.setBounds(230,220,150,25);

        DOBLabel = new JLabel("Date of Birth");
        DOBLabel.setBounds(100,260,150,25);

        DOBmodel = new UtilDateModel();
        DOBdatePanel = new JDatePanelImpl(DOBmodel, p);
        DOBdatePicker = new JDatePickerImpl(DOBdatePanel, new DateLabelFormatter());
        DOBdatePicker.setBounds(230,260,150,25);

        DOALabel = new JLabel("Date of Arrival");
        DOALabel.setBounds(100,300,150,25);

        DOAmodel = new UtilDateModel();
        DOAdatePanel = new JDatePanelImpl(DOAmodel, p);
        DOAdatePicker = new JDatePickerImpl(DOAdatePanel, new DateLabelFormatter());
        DOAdatePicker.setBounds(230,300,150,25);

        exhibLabel = new JLabel("Exhibits");
        exhibLabel.setBounds(100,340,150,25);
        exhibField = new JTextField();
        exhibField.setBounds(230,340,150,25);

        furryLabel = new JLabel("Has Furry? ");
        furryLabel.setBounds(100,380,150,25);
        furryCheckBox = new JCheckBox();
        furryCheckBox.setBounds(230,380,150,25);

        weightLabel = new JLabel("Weight");
        weightLabel.setBounds(100,420,150,25);
        weightField = new JTextField();
        weightField.setBounds(230,420,150,25);

        heightLabel = new JLabel("Height");
        heightLabel.setBounds(100,460,150,25);
        heightField = new JTextField();
        heightField.setBounds(230,460,150,25);

        addButton = new JButton("Add");
        addButton.setBounds(250, 515, 100, 40);

        this.add(title);
        this.add(idLabel);
        this.add(idField);
        this.add(nameLabel);
        this.add(nameField);
        this.add(genderLabel);
        this.add(genderComboBox);
        this.add(colourLabel);
        this.add(colourComboBox);

        this.add(DOBLabel);
        this.add(DOBdatePicker);
        this.add(DOALabel);
        this.add(DOAdatePicker);


        this.add(exhibLabel);
        this.add(exhibField);

        this.add(furryLabel);
        this.add(furryCheckBox);

        this.add(weightLabel);
        this.add(weightField);

        this.add(heightLabel);
        this.add(heightField);

        this.add(addButton);

        this.add(homeButton);

        homeButton.addActionListener(this);
        addButton.addActionListener(this);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(homeButton)){
            this.dispose();
            Dashboard dashboard = new Dashboard(animalController);
        }else if(e.getSource().equals(addButton)){

            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String gender = genderComboBox.getSelectedItem().toString();
            String colour = colourComboBox.getSelectedItem().toString();

            DateFormat format = new SimpleDateFormat("dd-MM-YYYY");

            Date dateOfBirth = null;
            try {
                dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(DOBdatePicker.getJFormattedTextField().getText());
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

            Date dateOfArrival = null;
            try {
                dateOfArrival = new SimpleDateFormat("yyyy-MM-dd").parse(DOAdatePicker.getJFormattedTextField().getText());
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

            int exhibitionNumb = Integer.parseInt(exhibField.getText());

            boolean furr = furryCheckBox.isSelected();

            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());

            Elephant elephant = new Elephant(id, name, gender, colour,
                    dateOfBirth, dateOfArrival, exhibitionNumb, furr, weight, height);

            animalController.getElephants().add(elephant);
            JOptionPane.showMessageDialog(null, "Elephant added Successfully");

            this.dispose(); // delete this window
            Dashboard dashboard = new Dashboard(animalController); // create dashboard
        }
    }
}
