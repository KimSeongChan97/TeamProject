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
		String sql = "update company_status set checkin_time = to_date('09:00','hh24:mi'), checkout_time = null, status = null, reason = null";
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
	public void getConnection() {	//연결
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//------------------------------------------------------------------------
	public void regist(String name, String id, String pw, String phone) {	//입사
		getConnection();
		
		String sql = "insert into company values(?,?,?,sysdate,?)";
		
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
		
		String sql2 = "insert into company_status values(?, ?, to_date('09:00','hh24:mi'), null, null, null)";
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
	public boolean isExistId(String id) {	//아이디 중복값 테스트
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
		String sql = "select * from company";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("name") + "\t" + 
							       rs.getString("id") + "\t" + 
							       sdf.format(rs.getDate("regist_day")) + "\t" + 
							       rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//------------------------------------------------------------------------
	public String delete(String id, String pw) {	//퇴사
		String name = null;
		getConnection();
		
		String sql1 = "delete from company where id = ? and pw = ?";
		String sql2 = "delete from company_status where id = ?";
		String sql3 = "select name from company where id = ? and pw = ?";
		
		try {
			pstmt = con.prepareStatement(sql3);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				name = rs.getString("name");
			}
			
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, id);
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
}
