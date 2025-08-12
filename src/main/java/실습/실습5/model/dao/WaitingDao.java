package 실습.실습5.model.dao;

import org.springframework.stereotype.Repository;
import 실습.실습5.model.dto.WaitingDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WaitingDao extends Dao{

    public boolean waitingAdd(WaitingDto dto){
        System.out.println("WaitingDao.waitingAdd");
        try{
            String sql = "insert into waiting(phone , count)values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getPhone());
            ps.setInt(2, dto.getCount());
            int c = ps.executeUpdate();
            if (c ==1 ) return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public List<WaitingDto> waitingPrint(){
        List<WaitingDto> list = new ArrayList<>();
        System.out.println("WaitingDao.waitingPrint");
        try{
            String sql = "select * from waiting";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int num = rs.getInt("num");
                String phone = rs.getString("phone");
                int count = rs.getInt("count");
                String wdata = rs.getString("wdata");
                WaitingDto dto = new WaitingDto(num , phone ,count ,wdata);
                list.add(dto);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public WaitingDto waitingPrint2(int num){
        System.out.println("WaitingDao.waitingPrint2");
        try{
            String sql = "select * from waiting where num = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, num);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String phone = rs.getString("phone");
                int count = rs.getInt("count");
                String wdata = rs.getString("wdata");
                WaitingDto dto = new WaitingDto(num , phone , count ,wdata );
                return dto;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    // 삭제
    public boolean waitingDelete(int num){
        System.out.println("WaitingDao.waitingDelete");
        try{
            String sql = "Delete from waiting where num = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, num);
            int c = ps.executeUpdate();
            if (c == 1){ return true; }
            else {return false;}
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
    // 수정
    public boolean waitingUpdate(WaitingDto dto){
        System.out.println("WaitingDao.waitingUpdate");
        try{
            String sql = "UPDATE waiting set phone = ? , count = ? where num =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getPhone());
            ps.setInt(2, dto.getCount());
            ps.setInt(3, dto.getNum());
            int c = ps.executeUpdate();
            if (c==1){ return true; }
            else {return false;}
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}
