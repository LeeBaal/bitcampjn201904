package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample10 {

	public static void main(String[] args) {
		// 1. 데이터베이스 드라이버 로드
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. 데이터베이스 연결
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			
			System.out.println("오라클 데이터베이스에 접속했습니다.");
			
			// 3. Statement 객체 생성
			Statement stmt = conn.createStatement();
			// insert 구문
			String sqlInsert = "insert into emp values (?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setInt(1, 8000);      			 // empno 
			pstmt.setString(2, "LEE");  	//	ename
			pstmt.setString(3, "COMPUTER");  		// 	job
			pstmt.setInt(4, 7839); 				//	mgr
			pstmt.setString(5, "96/04/30");	//	hiredate
			pstmt.setInt(6, 4000); 			//	sal
			pstmt.setInt(7, 1200); 			// comm
			pstmt.setInt(8, 40);			// deptno
			
			
			int resultCnt = pstmt.executeUpdate();
			if(resultCnt>0) {
				System.out.println("정상적으로 입력되었습니다.");
				System.out.println("=======================================");
			}
			
			// 4. SQL 실행 : select  / INSERT / UPDATE / DELETE 
			String sql1 = "select * from emp order by empno";
			
			ResultSet rs = stmt.executeQuery(sql1);
			// 5. 결과 출력
			System.out.println("=========================================");
			while(rs.next()) {
				System.out.println("사원번호"+ rs.getInt("empno"));
				System.out.println("사원이름"+ rs.getString(2));
				System.out.println("직업"+ rs.getString(3));
				System.out.println("상사"+ rs.getInt(4));
				System.out.println("입사일"+ rs.getString(5));
				System.out.println("월급"+ rs.getInt(6));
				System.out.println("보너스"+ rs.getInt(7));
				System.out.println("부서번호"+ rs.getInt(8));
				System.out.println("=========================================");
			}
			
			
			
			// 6. 사용 객체 CLOSE : ResultSet, Statement, Connection
			rs.close();
			stmt.close();
			pstmt.close();
			conn.close();
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
