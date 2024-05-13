package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Container;
import models.Student;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Read extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textRead;
	private JTextField txtId;
	
	Container container = new Container() ;

	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 */
	public Read() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textRead = new JTextField();
		textRead.setBounds(33, 127, 377, 64);
		panel.add(textRead);
		textRead.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana crud = new Ventana();
				crud.setVisible(true);
				crud.getContentPane().setLayout(null);
			}
		});
		btnBack.setBounds(248, 202, 89, 23);
		panel.add(btnBack);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int id = Integer.parseInt(txtId.getText());
		        Student student = container.read(id);
		        if (student != null) {
		            // Mostrar la información del estudiante en textRead
		            textRead.setText("ID: " + student.getId() + "\n" +
		                             "Name: " + student.getName() + "\n" +
		                             "Last Name: " + student.getLastname() + "\n" +
		                             "Age: " + student.getAge());
		        } else {
		            // Si no se encuentra el estudiante, mostrar un mensaje
		            textRead.setText("Student not found.");
		        }
		    }
		});

		btnSearch.setBounds(124, 202, 89, 23);
		panel.add(btnSearch);
		
		txtId = new JTextField();
		txtId.setBounds(33, 53, 199, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblID_Student = new JLabel("ID_Student");
		lblID_Student.setBounds(248, 56, 111, 14);
		panel.add(lblID_Student);
	}
}
