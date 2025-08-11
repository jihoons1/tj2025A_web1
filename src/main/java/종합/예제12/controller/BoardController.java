package 종합.예제12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 종합.예제12.model.dto.BoardDto;
import 종합.예제12.service.BoardService;

import java.util.List;

@RestController
@RequestMapping("/board") // + 공통 URL
public class BoardController {
    @Autowired private BoardService boardService;

    @PostMapping("") //http://localhost:8080/board/board
    public boolean boardAdd(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.boardAdd");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardService.boardAdd(boardDto);
        return result;
    }

    @GetMapping("") // http://localhost:8080/board/board
    public List<BoardDto> boardPrint() {
        System.out.println("BoardController.boardPrint");
        List<BoardDto> result = boardService.boardPrint();
        return result;
    }

    @GetMapping("/a") // http://localhost:8080/board/board/a?bno=5
    public BoardDto boardPrint2(@RequestParam int bno) {
        System.out.println("BoardController.boardPrint");
        BoardDto result = boardService.boardPrint2(bno);
        return result;
    }

    @DeleteMapping("") // http://localhost:8080/board/board?bno=1
    public boolean boardDelete(@RequestParam int bno){
        System.out.println("BoardController.boardDelete");
        boolean result = boardService.boardDelete(bno);
        return result;
    }

    @PutMapping("") //
    public boolean boardUpdate(@RequestBody BoardDto dto){
        System.out.println("BoardController.boardUpdate");
        boolean result = boardService.boardUpdate(dto);
        return result;
    }
}
