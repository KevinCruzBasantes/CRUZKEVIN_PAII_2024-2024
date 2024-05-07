package model_package;

import java.sql.Time;

public  class Generic {
	
	  private int id;
	    private String name;
	    private String lastName;
	    private int age;
	    private String description;
	    private String level;
	    private Time start_time;
	    private Time end_time;
	    private String day;
	    private int subject_id;
	    private int alumno_id;
	    private int professor_id;
	public Generic(int id, String name, String lastName, int age) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}
	public Generic(int id, String name, String description, String level) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.description = description;
		this.level = level;
	}
	// Constructor sobrecargado para Schedule
    public Generic(int id, int subject_id, int alumno_id, int professor_id, Time start_time, Time end_time, String day) {
        this.id = id;
        this.subject_id = subject_id;
        this.alumno_id = alumno_id;
        this.professor_id = professor_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.day = day;
    }
	
	public Time getStart_time() {
		return start_time;
	}
	public void setStart_time(Time start_time) {
		this.start_time = start_time;
	}
	public Time getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Time end_time) {
		this.end_time = end_time;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String toSubjectString() {
	    return "Subject [id=" + id + ", name=" + name + ", description=" + description +", level=" + level + "]";
	}

	public String toPersonString() {
	    return "Person [id=" + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age + "]";
	}
	@Override
	public String toString() {
	    return "Schedule [id=" + id + ", subject_id=" + subject_id + ", alumno_id=" + alumno_id + ", professor_id=" + professor_id + ", start_time=" + start_time + ", end_time=" + end_time + ", day=" + day + "]";
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	 // Métodos getter y setter para subject_id, alumno_id, y professor_id
    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getAlumno_id() {
        return alumno_id;
    }

    public void setAlumno_id(int alumno_id) {
        this.alumno_id = alumno_id;
    }

    public int getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }

}
