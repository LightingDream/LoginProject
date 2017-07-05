package adrui;
import java.sql.*;
public class LoginModel {
	private Statement state = null;
	private String sql = "select * from user";
	private ResultSet rs = null; 
	public String check(Connection conn, String user, String pass) throws SQLException{
		state = conn.createStatement();
		rs = state.executeQuery(sql);
		while(rs.next()){
			if(rs.getString(2).equals(user)){
				if(rs.getString(3).equals(pass)){
					String sno = rs.getString(1);
					return "1" + sno;
				}
				return "-1";
			}
		}
		return "0";
	}
}
