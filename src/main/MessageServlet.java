package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Javabean;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		try { 
	    Class.forName("com.mysql.cj.jdbc.Driver"); 
		Connection connect = DriverManager.getConnection(  "jdbc:mysql://localhost:3306/liuyanban?characterEncoding=utf-8","root","123456");
		Statement stmt = (Statement) connect.createStatement();   
		String sql = "select * from message";           
		ResultSet rs = stmt.executeQuery(sql);       //Ö´ÐÐÓï¾ä
		List<Javabean> list = new ArrayList<>();       
		while(rs.next()){                               
		Javabean note1 = new Javabean();                   
		note1.setId(rs.getInt("id"));               
		note1.setTitle(rs.getString("title"));       
		note1.setAuthor(rs.getString("author"));       
		note1.setContent(rs.getString("content"));
		note1.setDate(rs.getString("date"));
		
		list.add(note1);                            
		}
		request.setAttribute("list", list);        
		rs.close();                                   
		stmt.close();                                   
		connect.close();                                   
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		request.getRequestDispatcher("shouye.jsp").forward(request, response);
		
	
	}

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		}
}
