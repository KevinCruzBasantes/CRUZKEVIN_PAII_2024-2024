package Main;

public class Main {

	/*
	 * @autor Cruz Kevin
	 * Titulo: Inversion de dependencias
	 */
	public static void main(String[] args) {
		Figura figura1 = new Figura(new Circulo());
		Figura figura2 = new Figura(new Rectangulo());
		Figura figura3 = new Figura(new Triangulo());
	}

}
