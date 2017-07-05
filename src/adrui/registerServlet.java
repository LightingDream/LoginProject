package adrui;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Statement state = null;
    private static String sql = null;
   // private static String res = "false";
    private static ResultSet rs = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
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
		//doGet(request, response);
		String sno = request.getParameter("Sno");
		String user = request.getParameter("LoginUser");
		String pass = request.getParameter("LoginPass");
		Connection conn = (Connection)(getServletContext().getAttribute("conn"));
		try{
			state = conn.createStatement();
			sql = "select User from user";
			rs = state.executeQuery(sql);
			boolean f = true;
			while(rs.next()){
				if(rs.getString(1).equals(user)){
					f = false;
					break;
				}
			}
		//	System.out.println("Register");
			String res = "false";
			if(f){
				res = "true";
				System.out.println("f = true");
				sql = "insert into user values('" + sno + "', '" + user + "', '" + pass + "')";
				state.executeUpdate(sql);		
				
			}
			request.setAttribute("res", res);
			RequestDispatcher view = request.getRequestDispatcher("register.jsp");
			view.forward(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
