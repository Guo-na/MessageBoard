package loginregister;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterServlet() {
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
		response.setContentType("text/html;character=utf-8");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		String job=request.getParameter("job");
		String zyjn=request.getParameter("zyjn");
		String ylbg=request.getParameter("ylbg");
		String xwzx=request.getParameter("xwzx");
		String info=request.getParameter("info");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/liuyanban?characterEncoding=utf-8","root","123456");
			if(connect!=null) {
				System.out.println("数据库连接成功");
			}else {
				System.out.println("数据库连接失败");
			}
			
			String sql="insert into yonghu(id,name,password,sex,job,zyjn,ylbg,xwzx,info) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt=(PreparedStatement)connect.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			pstmt.setString(4, sex);
			pstmt.setString(5, job);
			pstmt.setString(6, zyjn);
			pstmt.setString(7, ylbg);
			pstmt.setString(8, xwzx);
			pstmt.setString(9, info);
			pstmt.executeUpdate();
			pstmt.close();
			connect.close();
			
			
			
			
		} catch ( SQLException e) {
		  e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("login.jsp").forward(request,response);
		
	}
	

}