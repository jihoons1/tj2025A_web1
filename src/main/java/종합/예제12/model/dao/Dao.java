package 종합.예제12.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
    // [DB연동]
    private String db_url = "jdbc:mysql://localhost:3306/exam12";
    private String db_user = "root";
    private String db_pass = "1234";
    // [DB연동 멤버변수]
    public Connection conn;

    // [DB연동 생성자]
    public Dao() {
        connect();
    }

    // [DB연동 메소드]
    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_user, db_pass);
            System.out.println("Dao.connect"); // soutm
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
