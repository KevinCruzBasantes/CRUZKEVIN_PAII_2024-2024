package ec.edu.uce.Proyecto_004;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Student;
import vista.Ventana;

/*
 * author: Cruz Kevin
 * tema: Conexion a base de datos con hibernate
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);
        
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            // Verifica si la configuración de Hibernate se realiza correctamente
            if (sessionFactory != null) {
                System.out.println("Configuración de Hibernate exitosa. Conexión establecida.");

                // Crea y muestra la ventana principal
                javax.swing.SwingUtilities.invokeLater(() -> {
                    Ventana frame = new Ventana();
                    frame.setVisible(true);
                });
            } else {
                System.out.println("Error al configurar Hibernate. No se pudo establecer la conexión.");
            }
        } catch (Exception e) {
            // Captura cualquier excepción y muestra el mensaje de error
            e.printStackTrace();
            System.out.println("Error al configurar Hibernate: " + e.getMessage());
        }
    }
}

