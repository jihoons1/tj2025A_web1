//package 실습.실습8포인트기능구현.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import 실습.실습8포인트기능구현.model.dao.MemberDao;
//import 실습.실습8포인트기능구현.model.dto.MemberDto;
//import 실습.실습8포인트기능구현.model.dto.PointDto;
//
//@Service
//public class MemberService {
//
//    @Autowired // 스프림 컨테이너 빈 등록 주입
//    private MemberDao memberDao;
//
//    // 회원가입
//    public int sign(MemberDto dto){
//        int result = memberDao.sign(dto);
//        if (result > 0){
//            PointDto pointDto = new PointDto();
//            pointDto.setMno();
//
//        }
//        return result;
//    }
//    // 로그인
//    public int login(MemberDto dto){
//        int re = memberDao.login(dto);
//        return re;
//    }
//}
