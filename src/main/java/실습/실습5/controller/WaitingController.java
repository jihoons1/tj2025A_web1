package 실습.실습5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 실습.실습5.model.dto.WaitingDto;
import 실습.실습5.service.WaitingService;

import java.util.List;

@RestController
@RequestMapping("/waiting")
public class WaitingController {
    @Autowired private WaitingService waitingService;

    @PostMapping("")
    public boolean waitingAdd(@RequestBody WaitingDto dto){
        System.out.println("WaitingController.waitingAdd");
        boolean result = waitingService.waitingAdd(dto);
        return result;
    }

    @GetMapping("")
    public List<WaitingDto> waitingPrint(){
        System.out.println("WaitingController.waitingPrint");
        List<WaitingDto> result = waitingService.waitingPrint();
        return result;
    }

    @GetMapping("/a")
    public WaitingDto waitingPrint(@RequestParam int num){
        System.out.println("WaitingController.waitingPrint");
        WaitingDto dto = waitingService.waitingPrint2(num);
        return dto;
    }

    @DeleteMapping("")
    public boolean waitingDelete(@RequestParam int num){
        System.out.println("WaitingController.waitingDelete");
        boolean result = waitingService.waitingDelete(num);
        return result;
    }

    @PutMapping("")
    public boolean waitingUpdate(@RequestBody WaitingDto dto){
        System.out.println("WaitingController.waitingUpdate");
        boolean result = waitingService.waitingUpdate(dto);
        return result;
    }

}
