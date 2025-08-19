package 실습.실습8포인트기능구현.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {

    private String d_url= "jdbc:mysql://localhost:3306pointlog0819/";
    private String d_user = "root";
    private String d_password = "1234";

    public Connection conn;

    public Dao() { }

    private void cone() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(d_url , d_user ,d_password);
            System.out.println("Dao.cone");
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
