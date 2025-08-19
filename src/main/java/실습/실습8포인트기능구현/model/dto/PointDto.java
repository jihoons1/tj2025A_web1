package 실습.실습8포인트기능구현.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class PointDto {
    private int plno;
    private int plpoint;
    private String plcomment;
    private String pldate ;
    private int mno;



}
