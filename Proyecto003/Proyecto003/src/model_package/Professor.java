package model_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Professor extends Generic implements IDAOGeneric{
	
	private PreparedStatement ps;
	
	public Professor(int id, String name, String LastName, int age) {
		super(id, name, LastName, age);
	}

	@Override
	public void create(Connection connection, Generic generic) {
	    try {
	        PreparedStatement ps = connection.prepareStatement("INSERT INTO Professor (id, name, lastname, age) VALUES (?,?,?,?)");
	        ps.setInt(1, generic.getId());
	        ps.setString(2, generic.getName());
	        ps.setString(3, generic.getLastName());
	        ps.setInt(4, generic.getAge());
	        ps.execute();
	        ps.close();
	    } catch (SQLException e) {
	        if (e.getErrorCode() == 1062) { 
	            System.out.println("Error: El id " + generic.getId() + " ya existe en la base de datos.");
	        } else {
	            e.printStackTrace(); 
	        }
	    }
	}

	
	public void read(Connection c, int id) throws SQLException {
		Professor pro = new Professor(0, "", "", 0);
		String sql = "SELECT * FROM Professor WHERE id = ?";
		ps = c.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			pro.setId(rs.getInt(1));
			pro.setName(rs.getString(2));
			pro.setLastName(rs.getString(3));
			pro.setAge(rs.getInt(4));
		}
		System.out.println(pro.toPersonString());
		ps.execute();
		ps.close();
 
	}
	@Override
	public void update(Connection connection, Generic generic, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("UPDATE Professor SET name=?, lastname=?, age=? WHERE id=?");
		ps.setString(1, generic.getName());
		ps.setString(2,generic.getLastName());
		ps.setInt(3, generic.getAge());
		ps.setInt(4, id);
		ps.execute();
		ps.close();
	}
	@Override
	public void delete(Connection connection, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("DELETE FROM Professor WHERE id=?");        
        ps.setInt(1, id);     
        ps.execute();
		ps.close();
		
	}
}
