package example.day08._2MVC.model.dato;

import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository // [3] Repository 빈 등록
public class MvcDao extends Dao {
    // 다음 레이어(계층) 없어서 @AutoWired 없다.
    // extends Dao 할 경우 db 연동 상송받아 사용한다

    public void method2() {
        System.out.println("MvcDao.method");
        try{
            String sql = "select * from mvc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("var1"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }


}
