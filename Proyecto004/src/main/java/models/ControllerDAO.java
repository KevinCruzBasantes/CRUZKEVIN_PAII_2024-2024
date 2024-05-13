package models;

public class ControllerDAO {
	StudentDAO studentDAO = new StudentDAO();
	public void save(Student student) {
		//Crear estudiante en la base de datos
		studentDAO.createStudent(student);
	}
	public Student read(int id) {
        // Leer estudiante de la base de datos y devolverlo
        return studentDAO.readStudent(id);
    }
}
