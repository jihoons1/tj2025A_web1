package 실습.실습5.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
    private String db_url = "jdbc:mysql://localhost:3306/waiting0812";
    private String db_user = "root";
    private String db_pass = "1234";
    public Connection conn;

    public Dao() {
        con();
    }

    private void con() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url,db_user,db_pass);
            System.out.println("Dao.con");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
