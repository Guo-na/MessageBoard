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

@WebServlet("/ReplyviewServlet")
public class ReplyviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub¡¢
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String author=request.getParameter("author");
//		author= new String(author.getBytes("ISO-8859-1"),"utf-8");
		String content=request.getParameter("content");
//		content= new String(content.getBytes("ISO-8859-1"),"utf-8");
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/liuyanban?characterEncoding=utf-8&useOldAliasMetadataBehavior=true","root","123456");
			String sql="select * from reply where author=? and content=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1,author);
			ps.setString(2,content);
			ResultSet rs = ps.executeQuery();	
			List<Javabean> list = new ArrayList<>();
			while (rs.next()) {
			Javabean note1 = new Javabean();
			
			note1.setName(rs.getString("name"));
			note1.setReply(rs.getString("reply"));
			list.add(note1);
			
			}
			request.setAttribute("list", list);
			rs.close();
			ps.close();
			cn.close();
			
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			} catch (SQLException e) {
			e.printStackTrace();
			}
		request.setAttribute("content",content);
		request.getRequestDispatcher("Replyview.jsp").forward(request, response);
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
