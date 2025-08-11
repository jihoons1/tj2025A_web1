package 종합.예제12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.예제12.model.dao.BoardDao;
import 종합.예제12.model.dto.BoardDto;

import java.util.List;

@Service
public class BoardService {
    @Autowired private BoardDao boardDao;


    public boolean boardAdd(BoardDto boardDto) {
        System.out.println("BoardService.boardAdd");
        boolean result = boardDao.boardAdd(boardDto);
        return result;
    }

    public List<BoardDto> boardPrint() {
        System.out.println("BoardService.boardPrint");
        return boardDao.boardPrint();

    }

    public BoardDto boardPrint2(int bno) {
        System.out.println("BoardService.boardPrint2");
        return boardDao.boardPrint2(bno);
    }

    public boolean boardDelete(int bno) {
        System.out.println("BoardService.boardDelete");
        return boardDao.boardDelete(bno);
    }

    public boolean boardUpdate(BoardDto dto){
        System.out.println("BoardService.boardUpdate");
        return boardDao.boardUpdate(dto);
    }
}
