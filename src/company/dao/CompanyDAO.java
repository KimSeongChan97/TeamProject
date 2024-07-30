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
<<<<<<< HEAD
		String sql = "update company_status set checkin_time = to_date('09:00','hh24:mi'), checkout_time = null, status = null, reason = null";
=======
		String sql = "update company_status set checkin_time = to_date(to_char(sysdate, 'YYYY-MM-DD') || ' 09:00', 'YYYY-MM-DD HH24:MI'), checkout_time = null, status = '결근', reason = null";
>>>>>>> 6500417 (리스트반복수정이전30일최종본)
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
<<<<<<< HEAD
	public void getConnection() {	//연결
=======
	//DB 연결
	public void getConnection() {
>>>>>>> 6500417 (리스트반복수정이전30일최종본)
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//------------------------------------------------------------------------
<<<<<<< HEAD
	public void regist(String name, String id, String pw, String phone) {	//입사
		getConnection();
		
		String sql = "insert into company values(?,?,?,sysdate,?)";
=======
	// 1. 입사
	public void regist(String name, String id, String pw, String phone) {	//입사
		getConnection();
		
		String sql = "insert into company values(?,?,?,?,sysdate,null,'N')";
>>>>>>> 6500417 (리스트반복수정이전30일최종본)
		
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
		
<<<<<<< HEAD
		String sql2 = "insert into company_status values(?, ?, to_date('09:00','hh24:mi'), null, null, null)";
=======
		String sql2 = "insert into company_status values(?, ?, to_date('09:00','hh24:mi'), null, '결근', null)";
>>>>>>> 6500417 (리스트반복수정이전30일최종본)
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
<<<<<<< HEAD
		String sql = "select * from company";
=======
		String sql = "select * from company,company_status where deleteyn = 'N'";
>>>>>>> 6500417 (리스트반복수정이전30일최종본)
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("name") + "\t" + 
							       rs.getString("id") + "\t" + 
							       sdf.format(rs.getDate("regist_day")) + "\t" + 
<<<<<<< HEAD
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
=======
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
		String sql = "update company_status set status = case when sysdate <= to_date(to_char(sysdate, 'YYYY-MM-DD') || ' 09:00', 'YYYY-MM-DD HH24:MI') then '출근' else '지각' end";
		
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
	public void checkout(String id) {		//퇴근
		getConnection();
		String sql = "update company_status set status = case when sysdate <= to_date(to_char(sysdate, 'YYYY-MM-DD') || ' 18:00', 'YYYY-MM-DD HH24:MI') then '조퇴' else '퇴근' end";
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
    public void addAttendance(String attendanceId, String companyId, String date, boolean isPresent) {
    	
        getConnection();
        try {
            // 데이터베이스 연결
            // SQL 문
            String sql = "update into company_status VALUES(?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, attendanceId);
            pstmt.setString(2, companyId);
            pstmt.setString(3, date);
            pstmt.setBoolean(4, isPresent);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
            	try {
            		if(pstmt != null) pstmt.close();
            		if(con != null) con.close();
            	} catch (SQLException e) {
            		e.printStackTrace();
            	} 
            }
        }
   }
	//퇴사
	public String delete(String id, String pw) {
		String name = null;
		getConnection();
		
		String sql1 = "select name from company where id = ? and pw = ?";
		String sql2 = "update company set id = null, leave_day = sysdate , deleteyn = 'Y' where id = ?";
		String sql3 = "delete from company_status where name = ?";
		
		try {
			pstmt = con.prepareStatement(sql1);
>>>>>>> 6500417 (리스트반복수정이전30일최종본)
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				name = rs.getString("name");
			}
			
<<<<<<< HEAD
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, id);
=======
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1,id);
			pstmt.executeUpdate();
			
			
			pstmt = con.prepareStatement(sql3);
			pstmt.setString(1,name);
>>>>>>> 6500417 (리스트반복수정이전30일최종본)
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
<<<<<<< HEAD
=======
	//------------------------------------------------------------------------
	//퇴사 사원 목록
	public void leavelist(CompanyDTO companyDTO) {
		getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sql = "select name,leave_day,phone from company where deleteyn = 'Y'";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("name") + "\t"
						+ sdf.format(rs.getDate("leave_day")) + "\t"
						+ rs.getString("phone"));
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
>>>>>>> 6500417 (리스트반복수정이전30일최종본)
}
