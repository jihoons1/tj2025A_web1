package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service // 스프링 컨테이너(메모리) 빈(객체) 등록
public class MemberService {
    @Autowired // 스프링 컨테이너(메모리)에 등록된 빈 주입(꺼내) 받기
    private MemberDao memberDao;

    // [1] 회원가입
    public int signUp(MemberDto memberDto ){
        int result = memberDao.signUp( memberDto );
        return result;
    }

    // [2] 로그인
    public int login ( MemberDto memberDto ){
        int result = memberDao.login( memberDto );
        return result;
    }

    // [4] 회원정보조회
    public MemberDto info(int mno) {
        MemberDto result = memberDao.info(mno);
        return result;
    }

    // [5] 특정한 필드/열/컬럼 의 값 중복/존재 확인
    public boolean check( String type , String data ){
        boolean result = memberDao.check( type , data );
        return result;
    }

    // [6] 회원정보 수정
    public boolean update(MemberDto dto){
        boolean result = memberDao.update(dto);
        return result;
    }

    // [7] 회원비밀번호수정
    public boolean updatePassword( int mno , Map<String,String> map ){
        boolean result = memberDao.updatePassword( mno , map );
        return result;
    }

    // [8] 회원탈퇴
    public boolean delete( int mno , String oldpwd ){
        boolean result = memberDao.delete( mno , oldpwd );
        return result;
    }

    // [9] 아이디 찾기
    public Map<String ,String> infoid(Map<String ,String> map){
        String result = memberDao.infoid(map);
        Map<String , String> maps = new HashMap<>();
        if (result == null) {
            maps.put("msg" , null);
        }else {
            maps.put("msg" , result);
        }
        return maps;
    }

    public Map<String , String > infopass( Map<String ,String > map){
        // 1. 컨트롤러로 부터 사용자에게 입력받은 아이디와 연락처를 매개변수로 받아
        // ***** 유호성 검사 , 추가적인 이벤트 *********
        // * 난수 생성 , 간단하게 0~9 사이의 6 자리 난ㅅ ㅜ생성 , 주의할점 : 문자열 타입 , 숫자는 앞에 6035
        String mpwd = "";
        for ( int i = 1 ; i<= 6; i++){ // 6 회전
            Random random = new Random();
            mpwd += random.nextInt(10); // 0~9 까지의 난수 생성
        }
        map.put("mpwd" , mpwd ); // 생성된 난수 비밀번호 map 속성 대입
        // 2. 다오 에게 입력받은 매개변수를 전달하여 결과를 확인한다.
        boolean result = memberDao.infopass(map);
        // 3. 만ㅇ갸에 result 가 성공이면
        Map<String , String > resultMap = new HashMap<>();
        if (result == true) {
            resultMap.put("msg", mpwd);
        }else { resultMap.put("msg", "회원정보없음"); }
        // 반환
        return resultMap;
    }

}