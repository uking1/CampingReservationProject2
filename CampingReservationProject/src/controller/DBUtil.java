package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    public static Connection makeConnection() {
        // 오라클 DB 연결 정보
        String url = "jdbc:oracle:thin:@localhost:1521/xe";
        String user = "javauser";
        String password = "javauser";
        Connection con = null;
        try {
            // JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
//            System.out.println("드라이버 적재 성공");
            // DB 연결
            con = DriverManager.getConnection(url, user, password);
//            System.out.println("오라클 접속 성공");
        } catch (ClassNotFoundException e) {
//            System.out.println("드라이버를 찾을 수 없습니다.");
        } catch (SQLException e) {
//            System.out.println("오라클 연결에 실패했습니다.");
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        Connection con = makeConnection();
    }
}