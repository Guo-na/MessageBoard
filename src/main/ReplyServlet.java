package main;

import java.io.IOException;
import java.sql.*;
import java.util.*;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Javabean;


@WebServlet("/ReplyServlet")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String author =  request.getParameter("author");
		String content =  request.getParameter("content");
		String name=request.getParameter("name");
		String reply=request.getParameter("reply");
	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn =DriverManager.getConnection("jdbc:mysql://localhost:3306/liuyanban?characterEncoding=utf-8","root","123456");
			String sql="insert into reply(author,content,name,reply) values(?,?,?,?)";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1,author);
			ps.setString(2,content);
			ps.setString(3,name);
			ps.setString(4,reply);
			ps.execute();
			
			String sql2="select * from reply where author=? and content=?";
			PreparedStatement ps2=cn.prepareStatement(sql2);
			ps2.setString(1,author);
			ps2.setString(2,content);
			ResultSet rs = ps2.executeQuery();	
			List<Javabean> list = new ArrayList<>();
			while (rs.next()) {
			Javabean note1 = new Javabean();
			
			note1.setName(rs.getString("name"));
			note1.setReply(rs.getString("reply"));
			list.add(note1);
			
			}
			request.setAttribute("list", list);
			

			ps.close();
			cn.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("Replyview.jsp").forward(request,response);
		
		
		
		
		
		
	}

}
