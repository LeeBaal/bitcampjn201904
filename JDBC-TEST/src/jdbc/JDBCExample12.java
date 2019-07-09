package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample12 {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			
			System.out.println("오라클 데이터베이스에 접속했습니다.");
			
			Statement stmt = conn.createStatement();
			
			String sqlUpdate = "update emp set sal=1000 where ename='SCOTT'";
			String sqlShow = "select sal from emp where ename='SCOTT'";
			
			ResultSet rs = stmt.executeQuery(sqlUpdate);
			System.out.println("스캇의 정보가 바꼇습니다.");
			ResultSet rd = stmt.executeQuery(sqlShow);
			System.out.println("==========================");
			while(rd.next()) {
				System.out.println("스캇의 바뀐 월급"+rd.getInt(1));
				System.out.println("=========================================");
			}
			
			
			
		}catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
