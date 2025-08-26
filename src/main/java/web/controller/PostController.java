package web.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import web.model.dto.PageDto;
import web.model.dto.PostDto;
import web.service.PostService;

@RestController // (1) HTTP 요청/응답 자료 매핑 기술
@RequestMapping("/post") // (2) HTTP URL 매핑 기술
@RequiredArgsConstructor // (3) final 변수에 대한 자동 생성자 주입
public class PostController {

    private final PostService postService; // @RequiredArgsConstructor 사용함으로 @Autowired 생략 한다.

    // [1] 게시물등록
    @PostMapping("")
    public int writePost(@RequestBody PostDto postDto , HttpSession session ){
        // 1. 현재 로그인 상태 확인
        Object login = session.getAttribute("loginMno");
        // 2. 비로그인이면 등록 실패처리
        if( login == null  ) return 0;
        // 3. 로그인이면 현재 로그인한 회원번호를 postDto 대입하기
        int mno = (int)login;
        postDto.setMno( mno );
        // 4. 서비스 호출 하고 응답 반환 하기
        return postService.writePost( postDto );
    } // func end

    // [2] 게시물 전체 조회
    @GetMapping("")
    // method : GET , URL : localhost:8080/post?cno=1&page=1&count=5  1번카테고리(뉴스)의 1페이지의 5개 게시물
    // method : GET , URL : localhost:8080/post?cno=1&page=2&count=10  2번카테고리(뉴스)의 2페이지의 10개 게시물
    // http://localhost:8080/post?cno=1&page=1&count=5
    // 검색이 있을때 : method : GET , URL : localhost:8080/post?cno=1&page=1&count=5  1번카테고리(뉴스)의 1페이지의 5개 게시물
    // 검색이 없을떄 : method : GET , URL : localhost:8080/post?cno=1&page=1&count=5&key=ptitle&keyword=ai ,   1번카테고리(뉴스)의 1페이지의 5개 게시물
    public PageDto findAllPost(
            @RequestParam( defaultValue = "1") int cno ,
            @RequestParam( defaultValue = "1") int page ,
            @RequestParam( defaultValue = "5") int count ,
            @RequestParam( required = false) String key ,
            @RequestParam( required = false) String keyword ) { // defaultValue : 값 생략시 기본값 대입
        // 만약에 URL 주소상의 쿼리스트링 매개변수가 없으면 defaultValue 속성으로 기본값 대입할 수 있다.
        // 만약에 URL 주소상의 쿼리스트링 매개변수가 존재하는 조건이 필수가 아닐때 required = false 속성을 사용한다.
        return postService.findAllPost(cno,page,count , key , keyword);


    }


} // class end