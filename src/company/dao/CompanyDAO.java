package company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import company.bean.CompanyDTO;

public class CompanyDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##java";
	private String password = "1234";
	
	private Connection con;				//인터페이스
	private PreparedStatement pstmt;	//인터페이스
	private ResultSet rs;				//인터페이스
	
	private static CompanyDAO instance = new CompanyDAO();
	
	//------------------------------------------------------------------------
	public CompanyDAO() {
		try {
			Class.forName(driver);		//생성
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//------------------------------------------------------------------------
	public static CompanyDAO getInstance() {
		return instance;
	}
	static {	//company_attendance 테이블 이름 아이디빼고 초기화
		instance.initialize();
	}
	public void initialize() {	//company_attendance 테이블 이름 아이디빼고 초기화
		getConnection();
		String sql = "update company_status set checkin_time = to_date(to_char(sysdate, 'YYYY-MM-DD') || ' 09:00', 'YYYY-MM-DD HH24:MI'), checkout_time = null, status = '결근', reason = null";
		 try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	//------------------------------------------------------------------------
	//DB 연결
	public void getConnection() {
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//------------------------------------------------------------------------
	// 1. 입사
	public void regist(String name, String id, String pw, String phone) {
		getConnection();
		
		String sql = "insert into company values(?,?,?,?,sysdate)";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,name);
			pstmt.setString(2,id);
			pstmt.setString(3,pw);
			pstmt.setString(4,phone);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql2 = "insert into company_status values(?, ?, to_date(to_char(sysdate, 'YYYY-MM-DD') || ' 09:00', 'YYYY-MM-DD HH24:MI'), null, '결근', null)";
		try {
			pstmt = con.prepareStatement(sql2);
			
			pstmt.setString(1,name);
			pstmt.setString(2,id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	//------------------------------------------------------------------------
	//아이디 중복 체크
	public boolean isExistId(String id) {
		boolean exist = false;
		getConnection();	

		try {
			String sql = "select * from company where id = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				exist = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return exist;
	}
	//------------------------------------------------------------------------
	public void list(CompanyDTO companyDTO) {	//사원 목록
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		getConnection();
		String sql = "select * from company JOIN company_status ON company.id = company_status.id";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("name") + "\t" + 
							       rs.getString("id") + "\t" + 
							       sdf.format(rs.getDate("regist_day")) + "\t" + 
							       rs.getString("phone") + "\t" +
							       rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//------------------------------------------------------------------------
	public String login(String id, String pw) {		//출결체크용 로그인
		String name = null;		
		getConnection();

		String sql = "Select * from company where id = ? and pw = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				name = rs.getString("name");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return name;
	}
	//------------------------------------------------------------------------
	public void checkin(String id) {		//출근
		getConnection();
		String sql = "update company_status set status = case when id = ? and sysdate <= to_date(to_char(sysdate, 'YYYY-MM-DD') || ' 09:00', 'YYYY-MM-DD HH24:MI') then '출근' when id = ? and sysdate > to_date(to_char(sysdate, 'YYYY-MM-DD') || ' 09:00', 'YYYY-MM-DD HH24:MI') then '지각' else status end where id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			pstmt.setString(3, id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void checkout(String id) {		//퇴근
		getConnection();
		String sql = "update company_status set status = case when id = ? and sysdate <= to_date(to_char(sysdate, 'YYYY-MM-DD') || ' 18:00', 'YYYY-MM-DD HH24:MI') then '조퇴' when id = ? and sysdate > to_date(to_char(sysdate, 'YYYY-MM-DD') || ' 18:00', 'YYYY-MM-DD HH24:MI') then '퇴근' else status end where id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			pstmt.setString(3, id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//------------------------------------------------------------------------
	//퇴사
	public String delete(String id, String pw) {
		String name = null;
		getConnection();
		
		//name값 가져오기
		String sql1 = "select name from company where id = ? and pw = ?";
		//company 테이블에서 데이터삭제
		String sql2 = "delete company where id = ?";
		//company_status 테이블에서 데이터 삭제
		String sql3 = "delete company_status where id = ?";
		//leaveperson 테이블에 퇴사한 인원 데이터 삽입(초기화x)
		String sql4 = "insert into leaveperson valeus(name, id, regist_day, leave_day) select ?, ?, regist_day,sysdate from company where id = ?";
		try {
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				name = rs.getString("name");
			}
			
			pstmt = con.prepareStatement(sql4);
			pstmt.setString(1,name);
			pstmt.setString(2,id);
			pstmt.setString(3,id);
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1,id);
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(sql3);
			pstmt.setString(1,id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return name;
	}
	//------------------------------------------------------------------------
	//퇴사 사원 목록
	public void leavelist(CompanyDTO companyDTO) {
		getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sql = "select * from leaveperson";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("name") + "\t"
						+ rs.getString("id") + "\t"
						+ sdf.format(rs.getDate("regist_day")) + "\t"
						+ sdf.format(rs.getDate("leave_day")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
	}
	//------------------------------------------------------------------------
}
