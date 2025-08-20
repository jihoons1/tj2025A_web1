//package 실습.실습8포인트기능구현.model.dao;
//
//import org.springframework.stereotype.Repository;
//import 실습.실습8포인트기능구현.model.dto.MemberDto;
//
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//@Repository
//public class MemberDao extends Dao {
//
//
//
//    // [1] 회원가입
//    public int sign(MemberDto dto){
//        try{
//            String sql = "insert into member( mid,mpwd,mname,mphone)values(?,?,?,?)";
//            PreparedStatement ps = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, dto.getMid());
//            ps.setString(1, dto.getMpwd());
//            ps.setString(1, dto.getMname());
//            ps.setString(1, dto.getMphone());
//            int count = ps.executeUpdate();
//            if (count == 1){
//                ResultSet rs = ps.getGeneratedKeys();
//                if (rs.next()){
//                    int mno = rs.getInt(1);
//                    return mno;
//                }
//            }
//        }catch (Exception e){
//            System.out.println(e);
//        }
//        return 0;
//    } // func end
//
//    // [2] 로그인
//    public int login(MemberDto dto){
//        try{
//            String sql = "select * from member where mid = ? and mpwd = ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, dto.getMid());
//            ps.setString(1, dto.getMpwd());
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()){
//                int mno = rs.getInt("mno");
//                return mno;
//            }
//        }catch (Exception e){
//            System.out.println(e);
//        }
//    }
//} // class end
