package loginregister;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Javabean;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		int h=0;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		System.out.println(name);
	   
		HttpSession session=request.getSession();
		session.setAttribute( "id",id);
		session.setAttribute( "name",name);
        session.setMaxInactiveInterval(2*325*24*60*60);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/liuyanban?characterEncoding=utf-8","root","123456");
			if(connect!=null) {
				System.out.println("���ݿ����ӳɹ�");
			}else {
				System.out.println("���ݿ�����ʧ��");
			}
			String sql="select * from yonghu where id='"+id+"' and password='"+password+"'";
			Statement stat=connect.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			if(rs.next()) {
				System.out.println("��¼�ɹ�");
				h=1;
			}
			else {
				System.out.println("��¼ʧ�ܣ��û��������������");
				request.setAttribute("failmessage","��½ʧ�ܣ��û��������������������������Ϣ");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
			rs.close();
			
			if(h==1) {
			String sql1 = "select * from message";      
			ResultSet rs1 = stat.executeQuery(sql1);       //ִ�����
			List<Javabean> list = new ArrayList<>();       
			while(rs1.next()){                               
			Javabean note = new Javabean();                   
			note.setId(rs1.getInt("id"));               
			note.setTitle(rs1.getString("title"));       
			note.setAuthor(rs1.getString("author"));       
			note.setContent(rs1.getString("content"));
			note.setDate(rs1.getString("date"));
			
			list.add(note);                            
			}
			request.setAttribute("list", list);        
			rs1.close();       
			request.getRequestDispatcher("shouye.jsp").forward(request, response);
			}
			
			
			stat.close();
			connect.close();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
