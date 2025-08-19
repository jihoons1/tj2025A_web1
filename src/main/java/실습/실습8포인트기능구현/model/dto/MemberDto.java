package 실습.실습8포인트기능구현.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class MemberDto {
    private int mno  ;    // 회원 번호 (기본키)
    private String  mid  ;  //   회원 아이디
    private String mpwd  ;  // 비밀번호
    private String mname ;  // 회원 이름
    private String mphone ; // 회원 연락처
    private String mdate ; // 가입일
}
