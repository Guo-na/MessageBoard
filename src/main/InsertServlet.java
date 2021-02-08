package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Javabean;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String title =  request.getParameter("title");
		String id =  request.getParameter("id");
		String author = request.getParameter("author");
		String content =request.getParameter("content");
		String date =request.getParameter("date");
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		Connection connect = DriverManager.getConnection( "jdbc:mysql://localhost:3306/liuyanban?characterEncoding=utf-8","root","123456");
	    String sql = null;
		sql = "insert into message(title,id,author,content,date) values(?,?,?,?,?)";
		PreparedStatement pstmt = connect.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, id);
		pstmt.setString(3, author);
		pstmt.setString(4, content); 
		pstmt.setString(5, date);
		
		pstmt.execute();
		sql = "select * from message";
		pstmt = connect.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<Javabean> list = new ArrayList<>();
		while (rs.next()) {
		Javabean note = new Javabean();
		note.setId(rs.getInt("id"));
		note.setTitle(rs.getString("title"));
		note.setAuthor(rs.getString("author"));
		note.setContent(rs.getString("content"));
		note.setDate(rs.getString("date"));
		
		list.add(note);}
		request.setAttribute("list", list);
		pstmt.close();
		connect.close();
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		request.getRequestDispatcher("shouye.jsp").forward(request, response);
		
	}

}
