package vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Container;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Student_Create extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JFormattedTextField txtID;
    private JTextField txtName;
    private JTextField txtLastName;
    private JFormattedTextField txtAge;

    Container container = new Container() ;

    public Student_Create() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        txtID = new JFormattedTextField();
        txtID.setBounds(42, 124, 267, 20);
        contentPane.add(txtID);
        txtID.setColumns(10);
        
        txtName = new JTextField();
        txtName.setBounds(42, 167, 267, 20);
        contentPane.add(txtName);
        txtName.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("ID");
        lblNewLabel.setBounds(319, 127, 46, 14);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setBounds(319, 170, 46, 14);
        contentPane.add(lblNewLabel_1);
        
        txtLastName = new JTextField();
        txtLastName.setBounds(42, 220, 267, 20);
        contentPane.add(txtLastName);
        txtLastName.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("LastName");
        lblNewLabel_2.setBounds(319, 223, 83, 14);
        contentPane.add(lblNewLabel_2);
        
        txtAge = new JFormattedTextField();
        txtAge.setBounds(42, 267, 267, 20);
        contentPane.add(txtAge);
        txtAge.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Age");
        lblNewLabel_3.setBounds(319, 270, 46, 14);
        contentPane.add(lblNewLabel_3);
        
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int Id = Integer.parseInt(txtID.getText());
                String Name = txtName.getText();
                String LastName = txtLastName.getText();
                int Age = Integer.parseInt(txtAge.getText());
                container.save(Id, Name, LastName, Age);
                JOptionPane optPanel = new JOptionPane("student was created successfully");
                optPanel.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optPanel.createDialog("created successfully");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
        });
        btnSave.setBounds(43, 315, 89, 23);
        contentPane.add(btnSave);
        
        JButton bttBack = new JButton("Back");
        bttBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Ventana ventana = new Ventana();
        		ventana.setVisible(true);
        	}
        });
        bttBack.setBounds(245, 315, 89, 23);
        contentPane.add(bttBack);
        
        JLabel lblNewLabel_4 = new JLabel("CREATE STUDENT");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNewLabel_4.setBounds(135, 42, 267, 40);
        contentPane.add(lblNewLabel_4);
        
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtID.setText("");
                txtName.setText("");
                txtLastName.setText("");
                txtAge.setText("");
            }
        });
        btnClear.setBounds(146, 315, 89, 23);
        contentPane.add(btnClear);
    }
}
