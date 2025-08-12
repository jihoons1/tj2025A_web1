package 정보처리산업기사.홈쇼핑회원관리프로그램.model.dao;

import org.springframework.stereotype.Repository;
import 정보처리산업기사.홈쇼핑회원관리프로그램.model.dto.ShoppingoneDto; // 회원 정보

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// assessment db
@Repository
public class ShoppingDao extends Dao{

    // 회원 등록
    public boolean shoppingAdd(ShoppingoneDto dto){
        System.out.println("ShoppingDao.shoppingAdd");
        try{
            String sql ="insert into MEMBER_TBL_02(custname,phone,address,joindate,grade,city)values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getCustname());
            ps.setString(2, dto.getPhone());
            ps.setString(3, dto.getAddress());
            ps.setString(4, dto.getJoindate());
            ps.setString(5, dto.getGrade());
            ps.setString(6, dto.getCity());
            int c = ps.executeUpdate();
            if (c== 1){return true;}
            else {return false; }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }


    // 조회
    public List<ShoppingoneDto> shoppingPrint(){
        List<ShoppingoneDto> list = new ArrayList<>();
        System.out.println("ShoppingDao.shoppingPrint");
        try{
            String sql = "select * from MEMBER_TBL_02";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int custno = rs.getInt("custno");
                String custname = rs.getString("custname");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String joindate = rs.getString("joindate");
                String grade = rs.getString("grade");
                String city = rs.getString("city");
                ShoppingoneDto dto = new ShoppingoneDto(custno,custname,phone,address,joindate,grade,city);
                list.add(dto);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }

}
