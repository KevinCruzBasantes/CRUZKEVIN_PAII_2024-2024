package Main;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Main extends JFrame  implements ActionListener {
	JFrame frame = new JFrame();

	public Main() {
		frame.setLayout(null);
		JButton botonTriangulo = new JButton("Triangulo");
		JButton botonCuadrado = new JButton("Cuadrado");
		JButton botonCirculo = new JButton("Cuadrado");
		botonTriangulo.setBounds(50, 50, 100, 50);
		frame.add(botonTriangulo);
		botonCuadrado.setBounds(50, 150, 100, 50);
		frame.add(botonCuadrado);
		botonCirculo.setBounds(50, 250, 100, 50);
		frame.add(botonCirculo);
		
		
        
        botonTriangulo.addActionListener(this);
        botonCuadrado.addActionListener(this);
        botonCirculo.addActionListener(this);
		
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Triangulo")) {
			dibujarTriangulo();
		} else if (e.getActionCommand().equals("Cuadrado")) {
			dibujarCuadrado();
		} else if (e.getActionCommand().equals("Circulo")) {
			dibujarCirculo();
		}

	}

	private void dibujarTriangulo() {
		System.out.println("Dibujando triángulo...");
	}

	private void dibujarCuadrado() {
		System.out.println("Dibujando cuadrado...");
	}

	private void dibujarCirculo() {
		System.out.println("Dibujando círculo...");
	}

	public static void main(String[] args) {

		Main ventana = new Main();
	}
}
