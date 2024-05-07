package model_package;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Subjects extends Generic implements IDAOGeneric{
	private PreparedStatement ps;
	public Subjects(int id, String name, String description, String level) {
		// TODO Auto-generated constructor stub
		super(id,name,description,level);
	}
	@Override
	public void create(Connection connection, Generic generic) {
	    try {
	        PreparedStatement ps = connection.prepareStatement("INSERT INTO Subject (id, name, description, level) VALUES (?,?,?,?)");
	        ps.setInt(1, generic.getId());
	        ps.setString(2, generic.getName());
	        ps.setString(3, generic.getDescription());
	        ps.setString(4, generic.getLevel());
	        ps.execute();
	        ps.close();
	    } catch (SQLException e) {
	        if (e.getErrorCode() == 1062) { //  error para Duplicate en MySQL
	            System.out.println("Error: El id " + generic.getId() + " ya existe en la base de datos.");
	        } else {
	            e.printStackTrace(); // 
	        }
	    }
	}

	@Override
	public void read(Connection c, int id) throws SQLException {
		// TODO Auto-generated method stub
		Subjects sub = new Subjects(0, "", "", "");
		String sql = "SELECT * FROM Alumns WHERE id = ?";
		ps = c.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			sub.setId(rs.getInt(1));
			sub.setName(rs.getString(2));
			sub.setDescription(rs.getString(3));
			sub.setLevel(rs.getString(4));
		}
		System.out.println(sub.toPersonString());
		ps.execute();
		ps.close();
	}

	@Override
	public void update(Connection connection, Generic generic, int id) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = connection.prepareStatement("UPDATE Subject SET name=?, description=?, level=? WHERE id=?");
		ps.setInt(1, generic.getId());
		ps.setString(2,getName());
		ps.setString(3, generic.getDescription());
		ps.setInt(4, id);
		ps.execute();
		ps.close();
	}

	@Override
	public void delete(Connection connection, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("DELETE FROM Subject WHERE id=?");        
        ps.setInt(1, id);     
        ps.execute();
		ps.close();
	}
}
