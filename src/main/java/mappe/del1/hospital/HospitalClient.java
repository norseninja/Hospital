package mappe.del1.hospital;

import mappe.del1.hospital.exception.RemoveException;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class HospitalClient {
    public static void main(String[] args) {

        final Hospital hospital = new Hospital("NTNU Sentralsykehus");
        HospitalTestData.fillRegisterWithTestData(hospital);

        JFrame frame = new JFrame("Hospital");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel mainPanel = (JPanel) frame.getContentPane();
        mainPanel.setLayout(null);

        JTextArea log = new JTextArea(5,30);
        log.setFocusable(false);
        log.setEditable(false);
        log.setLineWrap(true);
        log.setWrapStyleWord(true);
        JScrollPane windowScroll = new JScrollPane(log);
        windowScroll.setBounds(170,30,240,500);
        windowScroll.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(),"Logg", 1, 3));

        JTextArea hospitalList= new JTextArea();
        hospitalList.setFocusable(false);
        hospitalList.setEditable(false);
        hospitalList.setText(hospital.getAsString());
        JScrollPane hospitalListScroll = new JScrollPane(hospitalList);
        hospitalListScroll.setBounds(420,30,350,500);
        hospitalListScroll.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(),"Sykehuset", 1, 3));

        JButton removeEmployeeButton = new JButton ("Fjern ansatt");
        removeEmployeeButton.addActionListener(e -> {
            String socialSecurityNumber = JOptionPane.showInputDialog("Angi personnummeret til den ansatte som skal slettes:");
            boolean success = false;
            for (Department department : hospital.getDepartments()) {
                try {
                    department.remove(new Employee("Fjern", "Meg", socialSecurityNumber));
                } catch (RemoveException exception) {
                    log.append(exception.getMessage() + "\n\n");
                    success = true;
                }
            }
            if (!success) {
                log.append("Det finnes ingen ansatt med personnummer " + socialSecurityNumber + " i sykehusregisteret.\n\n");
            }
            hospitalList.setText(hospital.getAsString());
        });

        JButton removePatientButton = new JButton ("Fjern pasient");
        removePatientButton.addActionListener(e -> {
            String socialSecurityNumber = JOptionPane.showInputDialog("Angi personnummeret til pasienten som skal slettes:");
            boolean success = false;
            for (Department department : hospital.getDepartments()) {
                try {
                    department.remove(new Patient("Fjern", "Meg", socialSecurityNumber));
                } catch (RemoveException exception) {
                    log.append(exception.getMessage() + "\n\n");
                    success = true;
                }
            }
            if (!success) {
                log.append("Det finnes ingen pasient med personnummer " + socialSecurityNumber + " i sykehusregisteret.\n\n");
            }
            hospitalList.setText(hospital.getAsString());
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(removeEmployeeButton);
        buttonPanel.add(removePatientButton);
        buttonPanel.setBounds(10,32,150,496);
        buttonPanel.setLayout(new GridLayout(0,1));


        mainPanel.add(buttonPanel);
        mainPanel.add(windowScroll);
        mainPanel.add(hospitalListScroll);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }
}
