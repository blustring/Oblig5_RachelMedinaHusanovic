package View;

import Controller.AnimalController;
import model.Crocodile;
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

public class UpdateCrocodileForm extends JFrame implements ActionListener {

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

    private JLabel isVennonLabel;
    private JCheckBox isVennonCheckBox;

    private JLabel teethsLabel;
    private JTextField teethField;

    private JButton updateButton;

    private JButton homeButton;

    private AnimalController animalController;
    private int crocodileID;
    UpdateCrocodileForm(AnimalController animalController, int id){
        this.animalController = animalController;
        this.crocodileID = id;
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");


        Crocodile crocodile = null;

        for (Crocodile temp: animalController.getCrocodiles()){
            if (temp.getId() == id){
                crocodile = temp;
            }
        }

        this.setTitle("Update Crocodile");
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLayout(null);

        homeButton = new JButton("Dashboard");
        homeButton.setBounds(50, 30, 100, 30);

        title = new JLabel("Update Crocodile");
        title.setBounds(240,10,200,25);

        idLabel = new JLabel("ID");
        idLabel.setBounds(100,100,150,25);
        idField = new JTextField();
        idField.setBounds(230,100,150,25);

        idField.setText(crocodile.getId() + "");
        idField.disable();

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(100,140,150,25);
        nameField = new JTextField();
        nameField.setBounds(230,140,150,25);

        nameField.setText(crocodile.getName() + "");

        String [] genderValues= {"Male", "Female"};

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(100,180,150,25);
        genderComboBox = new JComboBox(genderValues);
        genderComboBox.setBounds(230,180,150,25);

        if (crocodile.getGender().equals("Male")){
            genderComboBox.setSelectedIndex(0);
        }else{
            genderComboBox.setSelectedIndex(1);
        }

        String colourValues[]={"Black","Grey","White","Orange"};

        colourLabel = new JLabel("Colour");
        colourLabel.setBounds(100,220,150,25);
        colourComboBox = new JComboBox(colourValues);
        colourComboBox.setBounds(230,220,150,25);

        if (crocodile.getColour().equals("Black")){
            colourComboBox.setSelectedIndex(0);
        }else if (crocodile.getColour().equals("Grey")){
            colourComboBox.setSelectedIndex(1);
        }else if (crocodile.getColour().equals("White")){
            colourComboBox.setSelectedIndex(2);
        }else if (crocodile.getColour().equals("Orange")){
            colourComboBox.setSelectedIndex(3);
        }

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

        exhibField.setText(crocodile.getExhibitionNumb()+"");

        isVennonLabel = new JLabel("Has venom? ");
        isVennonLabel.setBounds(100,380,150,25);
        isVennonCheckBox = new JCheckBox();
        isVennonCheckBox.setBounds(230,380,150,25);

        isVennonCheckBox.setSelected(crocodile.getIsVennon());

        teethsLabel = new JLabel("Number of Teeth");
        teethsLabel.setBounds(100,420,150,25);
        teethField = new JTextField();
        teethField.setBounds(230,420,150,25);

        teethField.setText(crocodile.getNumberOfTeeth()+"");

        updateButton = new JButton("Update");
        updateButton.setBounds(250, 470, 100, 40);

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

        this.add(isVennonLabel);
        this.add(isVennonCheckBox);

        this.add(teethsLabel);
        this.add(teethField);

        this.add(updateButton);
        this.add(homeButton);

        updateButton.addActionListener(this);
        homeButton.addActionListener(this);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(homeButton)){
            this.dispose();
            Dashboard dashboard = new Dashboard(animalController);
        }else if(e.getSource().equals(updateButton)){
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

            boolean venom = isVennonCheckBox.isSelected();
            int numOfTeeth = Integer.parseInt(teethField.getText());

            for (int i=0; i< animalController.getCrocodiles().size();i++){

                Crocodile crocodile = animalController.getCrocodiles().get(i);

                if (crocodile.getId() == crocodileID){
                    crocodile.setName(name);
                    crocodile.setGender(gender);
                    crocodile.setColour(colour);
                    crocodile.setDateOfBirth(dateOfBirth);
                    crocodile.setDateOfArrival(dateOfArrival);
                    crocodile.setIsVennon(venom);
                    crocodile.setNumberOfTeeth(numOfTeeth);
                    JOptionPane.showMessageDialog(null, "Crocodile Updated Successfully");
                    this.dispose(); // delete this window
                    Dashboard dashboard = new Dashboard(animalController); // create dashboard
                }
            }


        }
    }
}
