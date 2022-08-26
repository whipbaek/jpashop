package jpabook.jpashop.Controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberForm { //view 화면에서 fit 한 데이터를 주고 받기 위한 껍데기 클래스, Entity 는 최대한 순수하게 유지해야한다. (form, DTO 사용 해야함)
    @NotEmpty(message="회원 이름은 필수 입니다")
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
