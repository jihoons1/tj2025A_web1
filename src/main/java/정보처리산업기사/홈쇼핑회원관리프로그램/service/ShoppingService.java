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

    public boolean shoppingAdd(ShoppingoneDto dto){
        System.out.println("ShoppingService.shoppingAdd");
        boolean result = dao.shoppingAdd(dto);
        return result;
    }

    public List<ShoppingoneDto> shoppingPrint(){
        System.out.println("ShoppingService.shoppingPrint");
        List<ShoppingoneDto> dto = dao.shoppingPrint();
        return dto;
    }


}
