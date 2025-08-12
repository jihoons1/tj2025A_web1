package 정보처리산업기사.홈쇼핑회원관리프로그램.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 정보처리산업기사.홈쇼핑회원관리프로그램.model.dto.ShoppingoneDto;
import 정보처리산업기사.홈쇼핑회원관리프로그램.service.ShoppingService;

import java.util.List;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {
    @Autowired ShoppingService shoppingService;

    @PostMapping("")
    public boolean shoppingAdd(@RequestBody ShoppingoneDto dto){
        System.out.println("ShoppingController.shoppingAdd");
        System.out.println("dto = " + dto);
        boolean result = shoppingService.shoppingAdd(dto);
        return result;
    }

    @GetMapping("")
    public List<ShoppingoneDto> shoppingPrint(){
        System.out.println("ShoppingController.shoppingPrint");
        List<ShoppingoneDto> result = shoppingService.shoppingPrint();
        return result;
    }


}
