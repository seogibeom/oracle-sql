package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import vo.Emp;

public class EmpDAO {
	
	public static ArrayList<HashMap<String, Object>> selectJobCaseList() throws Exception  {
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		
		// DB연동
		Connection  conn = DBHelper.getConnection();
		String sql =	"select ename, job,"
				+ "        CASE "
				+ "        WHEN job = 'PRESIDENT' THEN '빨강' "
				+ "        WHEN job = 'MANAGER' THEN '주황' "
				+ "        WHEN job = 'ANALYST' THEN '노랑' "
				+ "        WHEN job = 'CLERK' THEN '초록' "
				+ "        ELSE '파랑' END color"
				+ " FROM emp"
				+ " ORDER BY (CASE"
				+ "        WHEN color = '빨강' THEN 1"
				+ "        WHEN color = '주황' THEN 2"
				+ "        WHEN color = '노랑' THEN 3"
				+ "        WHEN color = '초록' THEN 4"
				+ "        ELSE 5 END) ASC";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			HashMap<String, Object> m = new HashMap<>();
			m.put("ENAME", rs.getString("ENAME"));
			m.put("JOB", rs.getString("JOB")); 
			m.put("COLOR", rs.getString("COLOR")); 
			list.add(m);
		}
				
			return list;
	}
	// DEPTNO 뒤 부서별 인원을 같이 조회하는 메서드
	public static ArrayList<HashMap<String, Integer>> selectDeptNoCntList() throws Exception {
			
		ArrayList<HashMap<String, Integer>> list = new ArrayList<>();
		
		// DB연동
		Connection  conn = DBHelper.getConnection();
		
		String sql = "SELECT deptno deptNo, COUNT(*) cnt" 
				+ " FROM emp"
				+ " WHERE deptno IS NOT NULL"
				+ " GROUP BY deptno"
				+ " ORDER BY deptno ASC";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			HashMap<String, Integer> m = new HashMap<>();
			m.put("cnt", rs.getInt("cnt"));
			m.put("deptNo", rs.getInt("deptNo")); 
			list.add(m);
		}
		conn.close();
		
		return list;
	}
	
	// 중복을 제외한 DEPTNO 목록을 출력하는 메서드
	public static ArrayList<Integer> selectDeptNoList() throws Exception {
			ArrayList<Integer> list = new ArrayList<>();
			
			// DB연동
			Connection  conn = DBHelper.getConnection();
			
			String sql = "SELECT DISTINCT deptno AS deptNo\r\n"
					+ "FROM emp\r\n"
					+ "WHERE deptno IS NOT NULL\r\n"
					+ "ORDER BY deptno ASC";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Integer i = rs.getInt("deptNo"); // 랩퍼타입과 기본타입간에 Auto Boxing
				list.add(i);
			}
			conn.close();
			
			return list;
		}
	// 조인으로 Map을 사용하는 경우
	public static ArrayList<HashMap<String, Object>> selectEmpAndDeptList() throws Exception {
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		
		//DB연동
		Connection conn = DBHelper.getConnection();
		
		String sql = "SELECT"
				+ " emp.empno empNo, emp.ename ename, emp.deptno deptNo,"
				+ " dept.dname dname"
				+ " FROM EMP INNER JOIN dept"
				+ " ON emp.deptno = dept.deptno";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			HashMap<String, Object> m = new HashMap<>();
			m.put("empNo", rs.getInt("empNo"));
			m.put("ename", rs.getString("ename"));
			m.put("deptNo", rs.getInt("deptNo"));
			m.put("dname", rs.getString("dname"));
			list.add(m);
		}
		return list;
	}
	
	// 	VO 사용
	public static ArrayList<Emp> selectEmpList() throws Exception {
		ArrayList<Emp> list = new ArrayList<>();
		//DB연동
		Connection conn = DBHelper.getConnection();
		
		String sql = "SELECT"
				+ " empno empNo, ename, sal"
				+ " FROM emp";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Emp e = new Emp();
			//e.empNo = rs.getInt("empNo");
			e.setEmpNo(rs.getInt("empNo"));
			//e.ename = rs.getString("ename");
			e.setEname(rs.getString("ename"));
			//e.sal = rs.getDouble("sal");
			e.setSal(rs.getDouble("sal"));
			list.add(e);
		}
		
		return list;
	}
}