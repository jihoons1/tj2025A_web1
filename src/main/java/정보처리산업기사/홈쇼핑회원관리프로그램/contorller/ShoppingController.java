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

    // 등록
    @PostMapping("")
    public boolean shoppingAdd(@RequestBody ShoppingoneDto dto){
        System.out.println("ShoppingController.shoppingAdd");
        System.out.println("dto = " + dto);
        boolean result = shoppingService.shoppingAdd(dto);
        return result;
    }
    // 회원코드 가져오기
    @GetMapping("/custno")
    public int shoppingcode(){
        return shoppingService.shoppingcode();
    }
    // 조회
    @GetMapping("")
    public List<ShoppingoneDto> shoppingPrint(){
        System.out.println("ShoppingController.shoppingPrint");
        List<ShoppingoneDto> result = shoppingService.shoppingPrint();
        return result;
    }

    // 개별 정보
    @GetMapping("/a/update")
    public ShoppingoneDto shoppingPrint2(int custno ) {
        System.out.println("ShoppingController.shoppingPrint2");
        return shoppingService.shoppingPrint2(custno);

    }

    // 수정
    @PutMapping("/update")
    public boolean shoppingUpdate(ShoppingoneDto dto){
        System.out.println("ShoppingController.shoppingUpdate");
        boolean result = shoppingService.shoppingUpdate(dto);
        return result;
    }


}
