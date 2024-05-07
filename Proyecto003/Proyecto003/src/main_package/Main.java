package main_package;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;

import model_package.Alumn;
import model_package.Conexion;
import model_package.Professor;
import model_package.Schedule;
import model_package.Subjects;

/**
 * author: Cruz Kevin Tema: Inversion de dependencia y conexion a base de datos
 */
public class Main {
	public static void main(String[] args) throws SQLException {
		Conexion.getConnection();
		Professor pro1 = new Professor(1, "Marco", "Cedenio", 40);
		Professor pro2 = new Professor(1, "Rick", "Frick", 31);
		Subjects sub1 = new Subjects(1, "Programation Advance II", "=(=(=(=(=(", "Hard");
		sub1.create(Conexion.getConnection(), sub1);
		pro1.create(Conexion.getConnection(), pro1);
		pro1.read(Conexion.getConnection(), 1);
		pro1.update(Conexion.getConnection(), pro2, pro2.getId());
		pro1.delete(Conexion.getConnection(), 2);
		
		Time startTime = new Time(100);
		Time endTime = new Time(10000);
		Schedule sch = new Schedule(2, 1, 1, 1, startTime, endTime, "1");
		sch.read(Conexion.getConnection(), 2);

	}
}
