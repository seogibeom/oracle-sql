package dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBHelper {
	public static Connection getConnection() throws Exception {
	      Class.forName("oracle.jdbc.driver.OracleDriver");      
	      System.out.println("드라이브로딩성공");   
	      Connection conn = null;
	      //TNS_ADMIN 뒤는 전자지갑위치
	      String dbUrl =  "jdbc:oracle:thin:@gibeom2024_high?TNS_ADMIN=c:/oracle_Wallet/Wallet_gibeom2024";
	      String dbUser="admin";
	      String dbPw="Wldms1228@@@";
	      
	      //보안 이슈로 로컬에서 설정파일 로드 
	      FileReader fr = new FileReader("D:\\dev\\auth\\oracle.properties");
	      conn  = DriverManager.getConnection(dbUrl, dbUser, dbPw);
	      
	      return conn;
      
   }	
   // getConnection메서드 디버깅용
   public static void main(String[] args) throws Exception{
	      Connection conn = new DBHelper().getConnection();
	      System.out.println(conn+"<==conn");
   }
   
}   
