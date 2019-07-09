package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample13 {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			
			System.out.println("오라클 데이터베이스에 접속했습니다.");
			
			Statement stmt = conn.createStatement();
			
			String sql1 = "select * from emp where ename='SCOTT'";
			
			ResultSet rs = stmt.executeQuery(sql1);
			
			System.out.println("=====================");
			while(rs.next()) {
				System.out.println("사원번호"+ rs.getInt("empno"));
				System.out.println("사원이름"+ rs.getString(2));
				System.out.println("직업"+ rs.getString(3));
				System.out.println("상사"+ rs.getInt(4));
				System.out.println("입사일"+ rs.getString(5));
				System.out.println("월급"+ rs.getInt(6));
				System.out.println("보너스"+ rs.getInt(7));
				System.out.println("부서번호"+ rs.getInt(8));
				System.out.println("========================");
				
			}
			
			
		}
		
		
		catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
