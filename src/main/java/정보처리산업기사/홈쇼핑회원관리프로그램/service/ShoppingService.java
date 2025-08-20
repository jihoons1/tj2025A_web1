package 정보처리산업기사.홈쇼핑회원관리프로그램.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 정보처리산업기사.홈쇼핑회원관리프로그램.model.dao.ShoppingDao;
import 정보처리산업기사.홈쇼핑회원관리프로그램.model.dto.ShoppingoneDto;

import java.util.List;

@Service
public class ShoppingService {
    @Autowired
    ShoppingDao dao;

    //등록
    public boolean shoppingAdd(ShoppingoneDto dto){
        System.out.println("ShoppingService.shoppingAdd");
        boolean result = dao.shoppingAdd(dto);
        return result;
    }
    //회원 코드 가져오기
    public int shoppingcode(){
        System.out.println("ShoppingService.nextCustno");
        return dao.shoppingcode();
    }
    // 회원 조회
    public List<ShoppingoneDto> shoppingPrint(){
        System.out.println("ShoppingService.shoppingPrint");
        List<ShoppingoneDto> dto = dao.shoppingPrint();
        return dto;
    }

    // 개별 조회
    public ShoppingoneDto shoppingPrint2(int custno) {
        System.out.println("ShoppingService.shoppingPrint2");
        return dao.shoppingPrint2(custno);
    }

    // 수정하기
    public boolean shoppingUpdate(ShoppingoneDto dto){
        System.out.println("ShoppingService.shoppingUpdate");
        boolean result = dao.shoppingUpdate(dto);
        return result;
    }


}
