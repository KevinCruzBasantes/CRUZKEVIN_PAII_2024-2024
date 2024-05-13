package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel CRUD;
    private JButton btnTeacher;
    private JButton btnSchedule;

    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 338, 412);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnStudent = new JButton("Student");
        btnStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mostrar el panel CRUD
                CRUD.setVisible(true);
                // Ocultar los botones Teacher y Schedule
                btnTeacher.setVisible(false);
                btnSchedule.setVisible(false);
            }
        });
        btnStudent.setBounds(29, 77, 89, 23);
        contentPane.add(btnStudent);

        btnTeacher = new JButton("Teacher");
        btnTeacher.setBounds(29, 156, 89, 23);
        contentPane.add(btnTeacher);

        btnSchedule = new JButton("Schedule");
        btnSchedule.setBounds(29, 236, 89, 23);
        contentPane.add(btnSchedule);

        CRUD = new JPanel();
        CRUD.setBackground(Color.LIGHT_GRAY);
        CRUD.setBounds(148, 0, 174, 373);
        contentPane.add(CRUD);
        CRUD.setLayout(null);

        JButton btnCreate = new JButton("Create");
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student_Create crud = new Student_Create();
                crud.setVisible(true);
                // Cerrar la ventana actual
                dispose();
            }
        });
        btnCreate.setBounds(49, 61, 89, 23);
        CRUD.add(btnCreate);

        JButton btnRead = new JButton("Read");
        btnRead.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Read read = new Read();
				read.setVisible(true);
				read.getContentPane().setLayout(null);
        	}
        });
        btnRead.setBounds(49, 140, 89, 23);
        CRUD.add(btnRead);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(49, 225, 89, 23);
        CRUD.add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(49, 296, 89, 23);
        CRUD.add(btnDelete);

        // Ocultar el panel CRUD al inicio
        CRUD.setVisible(false);
    }
}


