package 실습.실습5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 실습.실습5.model.dao.WaitingDao;
import 실습.실습5.model.dto.WaitingDto;

import java.util.List;

@Service
public class WaitingService {
    @Autowired private WaitingDao waitingDao;

    public boolean waitingAdd(WaitingDto dto){
        System.out.println("WaitingService.waitingAdd");
        boolean result = waitingDao.waitingAdd(dto);
        return result;
    }
    public List<WaitingDto> waitingPrint(){
        System.out.println("WaitingService.waitingPrint");
        List<WaitingDto> result =  waitingDao.waitingPrint();
        return result;
    }
    public WaitingDto waitingPrint2(int num){
        System.out.println("WaitingService.waitingPrint2");
        WaitingDto dto = waitingDao.waitingPrint2(num);
        return dto;
    }

    public boolean waitingDelete(int num){
        System.out.println("WaitingService.waitingDelete");
        boolean result = waitingDao.waitingDelete(num);
        return result;
    }

    public boolean waitingUpdate(WaitingDto dto){
        System.out.println("WaitingService.waitingUpdate");
        boolean result = waitingDao.waitingUpdate(dto);
        return result;
    }
}
