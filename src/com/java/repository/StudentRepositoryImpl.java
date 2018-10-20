package com.java.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.dto.Student;
import com.java.exception.DatabaseException;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
	
	public Map<Integer, Student> map= new HashMap<>();
	@Autowired
	BasicDataSource ds;

	@Override
	public int addStudent(Student student) throws DatabaseException{
		int id= -1;
		try (
			Connection conn = ds.getConnection();
			Statement st = conn.createStatement();
			){
			st.executeQuery("select idGenerator.nextval from dual");
			ResultSet set=st.executeQuery("select idGenerator.currval from dual");
			while(set.next()) {
				 id=set.getInt("currval");
				 
			}
			st.executeUpdate("insert into student values ("+id+" , '" + student.getName() + "' ,'"
					+ student.getPassword() + "')");
			
			set.close();
		} catch (SQLException e) {
			
			throw new DatabaseException("Unable to insert record into db"+ e.getMessage());
		}
		return id;
	}

	@Override
	public void updateStudent(Student student) throws DatabaseException{
		
		int ret =0;
		String updateStudent = "UPDATE student SET name=?,password=? where id=?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pst = conn.prepareStatement(updateStudent);){
			
			
			pst.setString(1,student.getName());
			pst.setString(2,student.getPassword());
			pst.setInt(3,student.getId());
			

			ret =pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DatabaseException("Unable to update record"+ e.getMessage());
			}
			
			
		
	}

	@Override
	public void deleteStudent(int id) throws DatabaseException {
		
		String delStudent ="DELETE from student WHERE id=?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pst = conn.prepareStatement(delStudent);){
		pst.setInt(1, id);
		pst.execute();
		}catch(SQLException e) {
			throw new DatabaseException("Unable to update record"+ e.getMessage());
		}

		
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudents() throws DatabaseException {
		
		List<Student> list=new ArrayList();
		 
			String selectAllStudent ="select * from Student";
			try(Connection conn = ds.getConnection();
					PreparedStatement pst = conn.prepareStatement(selectAllStudent);
			ResultSet rs = pst.executeQuery();){
			
			
			//Student us=new Student();
			while(rs.next())
			{
				int id= rs.getInt("id");
				
				String name= rs.getString("name");
				Student st=new Student(id,name);
				list.add(st);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DatabaseException("Unable to fetch records"+ e.getMessage());
			}
			
		
			return list;
	}

}
