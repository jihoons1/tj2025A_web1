package 정보처리산업기사.홈쇼핑회원관리프로그램.model.dto;

import lombok.*;
// 회원매출정보
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ShoppingtwoDto {
    private int custno;     // no.
    private int salenol;    //
    private int pcost;  // 단가
    private int amount; // 수량
    private int price;  // 가격(금액)
    private String pcode;   //상품코드
    private String sdate;   // 판매일자

}
