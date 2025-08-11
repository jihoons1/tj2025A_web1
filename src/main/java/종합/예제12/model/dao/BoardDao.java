package 종합.예제12.model.dao;

import org.springframework.stereotype.Repository;
import 종합.예제12.model.dto.BoardDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDao extends Dao {

    // 등록
    public boolean boardAdd(BoardDto boardDto){
        System.out.println("BoardDao.boardAdd");
        try{
            String sql = "insert into board(bcontent,bwriter)values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBcontent());
            ps.setString(2, boardDto.getBwriter());
            int c = ps.executeUpdate();
            if (c== 1) return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    // 검색
    public List<BoardDto> boardPrint() {
        List<BoardDto> list = new ArrayList<>();
        System.out.println("BoardDao.boardPrint");
        try{
            String sql = "select * from board";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int bno = rs.getInt("bno");
                String bcontent = rs.getString("bcontent");
                String bwriter = rs.getString("bwriter");
                BoardDto boardDto = new BoardDto(  bno , bcontent , bwriter );
                list.add(boardDto);
            }

        }catch (Exception e){
            System.out.println(e);


        }
        return list;
    }

    // 세부 검색
    public BoardDto boardPrint2(int bno) {
        System.out.println("BoardDao.boardPrint2");
        try{
            String sql = "select * from board where bno =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,bno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String bcontent = rs.getString("bcontent");
                String bwriter = rs.getString("bwriter");
                BoardDto boardDto = new BoardDto(  bno , bcontent , bwriter );
                return boardDto;
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    //삭제
    public boolean boardDelete(int bno) {
        List<BoardDto> list = new ArrayList<>();
        System.out.println("BoardDao.boardPrint2");
        try {
            String sql = "DELETE from board where bno =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bno);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    // 수정
    public boolean boardUpdate(BoardDto dto) {
        List<BoardDto> list = new ArrayList<>();
        System.out.println("BoardDao.boardUpdate");
        try{
            String sql = "update board set bcontent = ?  where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(2, dto.getBno());
            ps.setString(1, dto.getBcontent());
            int c = ps.executeUpdate();
            if (c== 1) { return true; }
            else { return false; }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }// asdasdasdasdasd144
}
