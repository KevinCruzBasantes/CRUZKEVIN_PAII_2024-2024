package model_package;
import java.sql.Connection;
import java.sql.SQLException;

public interface IDAOGeneric {
	public void create(Connection connection, Generic generic) throws SQLException;
	public void read(Connection connection, int id) throws SQLException;
	public void update(Connection connection,  Generic generic, int id)throws SQLException;
	public void delete(Connection connection, int id)throws SQLException;
}
