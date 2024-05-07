package model_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class Schedule extends Generic implements IDAOGeneric {

	public Schedule(int id, int subject_id, int alumno_id, int professor_id, Time start_time, Time end_time,
			String day) {
		super(id, subject_id, alumno_id, professor_id, start_time, end_time, day);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Connection connection, Generic generic) throws SQLException {
	    PreparedStatement ps = connection.prepareStatement("INSERT INTO Schedule (id, subject_id, alumno_id, professor_id, start_time, end_time, day) VALUES (?,?,?,?,?,?,?)");
	    ps.setInt(1, generic.getId());
	    ps.setInt(2, generic.getSubject_id()); 
	    ps.setInt(3, generic.getAlumno_id()); 
	    ps.setInt(4, generic.getProfessor_id()); 
	    ps.setTime(5, generic.getStart_time());
	    ps.setTime(6, generic.getEnd_time());
	    ps.setString(7, generic.getDay());
	    ps.execute();
	    ps.close();
	}

	@Override
	public void read(Connection connection, int id) throws SQLException {
	    PreparedStatement ps = connection.prepareStatement("SELECT * FROM Schedule WHERE id = ?");
	    ps.setInt(1, id);
	    ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
	        this.setId(rs.getInt("id"));
	        this.setSubject_id(rs.getInt("subject_id")); 
	        this.setAlumno_id(rs.getInt("alumno_id")); 
	        this.setProfessor_id(rs.getInt("professor_id")); 
	        this.setStart_time(rs.getTime("start_time"));
	        this.setEnd_time(rs.getTime("end_time"));
	        this.setDay(rs.getString("day"));
	    }
	    System.out.println(this.toString());
	    ps.close();
	}

	@Override
	public void update(Connection connection, Generic generic, int id) throws SQLException {
	    PreparedStatement ps = connection.prepareStatement("UPDATE Schedule SET subject_id=?, alumno_id=?, professor_id=?, start_time=?, end_time=?, day=? WHERE id=?");
	    ps.setInt(1, generic.getSubject_id()); 
	    ps.setInt(2, generic.getAlumno_id()); 
	    ps.setInt(3, generic.getProfessor_id()); 
	    ps.setTime(4, generic.getStart_time());
	    ps.setTime(5, generic.getEnd_time());
	    ps.setString(6, generic.getDay());
	    ps.setInt(7, id);
	    ps.execute();
	    ps.close();
	}


	@Override
	public void delete(Connection connection, int id) throws SQLException {
	    PreparedStatement ps = connection.prepareStatement("DELETE FROM Schedule WHERE id=?");
	    ps.setInt(1, id);
	    ps.execute();
	    ps.close();
	}


}
