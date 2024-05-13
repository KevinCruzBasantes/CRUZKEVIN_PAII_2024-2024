package models;

public class Container {
	ControllerDAO controllerDAO = new ControllerDAO();

	public void save(int id, String name, String lastName, int age) {
		// TODO Auto-generated method stub
		//Crear estudiante
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setLastname(lastName);
		student.setAge(age);
		controllerDAO.save( student);
	}

	public Student read(int id) {
        return controllerDAO.read(id);
    }
}
