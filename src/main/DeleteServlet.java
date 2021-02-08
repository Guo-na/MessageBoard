package main;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import bean.Javabean;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id =  request.getParameter("id");
		
	    String id1=  request.getParameter("id1");
	    
	    
		String content=request.getParameter("content");
//		content= new String(content.getBytes("ISO-8859-1"),"utf-8"); //解决传递中文乱码的情况
		
		
		if(id.equals(id1)) {    //java中判断字符串是否相等不能用==和！=
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/liuyanban?characterEncoding=utf-8","root","123456");
			
	
			String sql="delete from message where id=? and content=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, content);

			ps.executeUpdate();
			System.out.println("删除");
			
			
		    sql= "select * from message";
			ps=cn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			List<Javabean> list = new ArrayList<>();
			while(rs.next()) {
				Javabean note = new Javabean();
				note.setId(rs.getInt("id"));
				note.setTitle(rs.getString("title"));
				note.setAuthor(rs.getString("author"));
				note.setContent(rs.getString("content"));
				note.setDate(rs.getString("date"));
				
				list.add(note);
				
			}
			request.setAttribute("list", list);
			
			ps.close();
			rs.close();
			cn.close();
						
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("shouye.jsp").forward(request, response);
		}
		else {
			
			request.getRequestDispatcher("error.jsp").forward(request, response);}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
		
		
		
	}

}
