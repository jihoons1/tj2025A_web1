package 정보처리산업기사.홈쇼핑회원관리프로그램.model.dto;

import lombok.*;
// 회원정보
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class ShoppingoneDto {
    private int custno;
    private String custname; // 회원성명
    private String phone;   // 연락처
    private String address; // 주소
    private String joindate; // 가입일자
    private String grade;   // 고객등급
    private String city;    //거주도시코드

}
