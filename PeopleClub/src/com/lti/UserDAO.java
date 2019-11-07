package com.lti;

import java.sql.*;
import java.util.ArrayList;
public class UserDAO 
{
	DatabaseConnector db=new DatabaseConnector();
	
	//Authenticating User
	public User authenticateUser(User u)
	{
		User user=null;
		int id=u.getId();
		int idD=0;
		String password=u.getPassword();
		String passwordD="";
		
		try
		{
			String query="Select id,password from peopleclub where id='"+id+"'";
			ResultSet rs=db.getResultSet(query);
			
			if(rs.next())
			{
				idD=rs.getInt("id");
				passwordD=rs.getString("password");
				
			}
			
			if(id==idD && password.equals(passwordD))
			{
				user=getUserById(idD);
			}
			else
			{
				user=null;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			db.closeConnection();
		}
		
		return user;
	}
	
	
	
	//Adding new User
	public String addUser(User u)
	{
		String result="";
		
		try
		{
			String query="Insert into peopleclub values (?,?,?,?,?,?)";
			PreparedStatement pstmt=db.getPreparedStatement(query);
			pstmt.setString(1, u.getFname());
			pstmt.setString(2, u.getLname());
			pstmt.setInt(3,u.getId());
			pstmt.setInt(4,u.getDob());
			pstmt.setString(5, u.getCity());
			pstmt.setString(6, u.getPassword());
			
			int i=pstmt.executeUpdate();
			
			if(i==1)
			{
				result=Results.SUCCESS;
			}
			else
			{
				result=Results.FAILURE;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result=Results.PROBLEM;
		}
		finally
		{
			db.closeConnection();
		}
		
		return result;
	}
	
	
	
	
	
	//Delete a user
	public String deleteUser(User u)
	{
		String result="";
		
		try
		{
			String query="delete from peopleclub where id=?";;
			PreparedStatement pstmt=db.getPreparedStatement(query);
			pstmt.setInt(1,u.getId());
			
			int i=pstmt.executeUpdate();
			
			if(i==1)
			{
				result=Results.SUCCESS;
			}
			else
			{
				result=Results.FAILURE;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result=Results.PROBLEM;
		}
		finally
		{
			db.closeConnection();
		}
		
		return result;
	}
	
	
	
	//Getting user By Id
	public User getUserById(int id)
	{
		User u=null;
		
		try
		{
			String query="Select * from peopleclub where id="+id;
			ResultSet rs=db.getResultSet(query);
			if(rs.next())
			{
				u=new User();
				u.setFname(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setId(rs.getInt("id"));
				u.setDob(rs.getInt("dob"));
				u.setCity(rs.getString("city"));
				u.setPassword(rs.getString("password"));
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		
		}
		finally
		{
			db.closeConnection();
		}
		
		return  u;
	}
	
	
	//Fetching all users
	public ArrayList<User> getAllUsers()
	{
		ArrayList<User> list=new ArrayList<>();
		
		
		try
		{
			String query="Select * from peopleclub";
			ResultSet rs=db.getResultSet(query);
			while(rs.next())
			{
				User u=new User();
				u.setFname(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setId(rs.getInt("id"));
				u.setDob(rs.getInt("dob"));
				u.setCity(rs.getString("city"));
				u.setPassword(rs.getString("password"));
				list.add(u);
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		
		}
		finally
		{
			db.closeConnection();
		}
		
		return  list;
	}




}
