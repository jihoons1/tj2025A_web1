package 정보처리산업기사.홈쇼핑회원관리프로그램.model.dao;

import org.springframework.stereotype.Repository;
import 정보처리산업기사.홈쇼핑회원관리프로그램.model.dto.ShoppingoneDto; // 회원 정보

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// assessment db
@Repository
public class ShoppingDao extends Dao{


    // 회원번호 메소드 가져오기
    public int shoppingcode(){
        System.out.println("ShoppingDao.shoppingcode");
        try{
            String sql = "SELECT COALESCE(MAX(custno),0) + 1 AS cus FROM MEMBER_TBL_02;"; // gpt 참고
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                return rs.getInt("cus");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }


    // 회원 등록
    public boolean shoppingAdd(ShoppingoneDto dto){
        System.out.println("ShoppingDao.shoppingAdd");
        try{
            String sql ="insert into MEMBER_TBL_02(custno,custname,phone,address,joindate,grade,city)values(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, dto.getCustno());
            ps.setString(2, dto.getCustname());
            ps.setString(3, dto.getPhone());
            ps.setString(4, dto.getAddress());
            ps.setString(5, dto.getJoindate());
            ps.setString(6, dto.getGrade());
            ps.setString(7, dto.getCity());
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
            String sql = "select * from MEMBER_TBL_02 ";
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

                Map<String, String> gradeMap = Map.of("A","VIP","B","일반","C","직원"); // GPT 참고..
                String graderank = gradeMap.get(grade); // GPT 참고..
                ShoppingoneDto dto = new ShoppingoneDto(custno,custname,phone,address,joindate,graderank,city);
                list.add(dto);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }

    // 개별 조회
    public ShoppingoneDto shoppingPrint2(int custno){
        System.out.println("ShoppingDao.shoppingUpdating");
        try{
            String sql = "select * from MEMBER_TBL_02 where custno = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,custno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int bcustno = rs.getInt("custno");
                String bcustname = rs.getString("custname");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String joindate = rs.getString("joindate");
                String grade = rs.getString("grade");
                String city = rs.getString("city");
                ShoppingoneDto dto = new ShoppingoneDto(bcustno,bcustname,phone,address,joindate,grade,city);
                return dto;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }


    // 수정
    public boolean shoppingUpdate(ShoppingoneDto dto){
        System.out.println("ShoppingDao.shoppingUpdate");
        try{
            String sql = "update MEMBER_TBL_02 set custname=? ,phone=? ,address=? , grade=? ,city=? where custno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getCustname());
            ps.setString(2, dto.getPhone());
            ps.setString(3, dto.getAddress());
            ps.setString(4, dto.getGrade());
            ps.setString(5, dto.getCity());
            ps.setInt(6, dto.getCustno());
            int count = ps.executeUpdate();
            if (count == 1){
                return true;}
            }catch (Exception e){
            System.out.println(e+" 수정 오류 발생 ");
        }
        return false;
    }

}
