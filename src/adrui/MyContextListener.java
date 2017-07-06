package adrui;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;
import javax.servlet.*;

public class MyContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event){
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		ServletContext sc = event.getServletContext();
		String driver = sc.getInitParameter("driver");
		String url = sc.getInitParameter("url");
		String user = sc.getInitParameter("user");
		String pass = sc.getInitParameter("pass");
		try{
			Class.forName(driver);//加载驱动程序类, 高版本jdbc可以省去, 相关可自行百度
			Connection conn = DriverManager.getConnection(url, user, pass);
			sc.setAttribute("conn", conn);
			System.out.println("Connect Succeed!");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
