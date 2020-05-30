package ro.converter;

import org.springframework.stereotype.Component;
import ro.domain.MyUser;
import ro.dto.MemberDto;

@Component
public class MemberConverter extends BaseConverter<MyUser, MemberDto> {

    @Override
    public MemberDto convertModelToDto(MyUser myUser) {
        MemberDto member = new MemberDto(myUser.getFullName(), myUser.getUsername(), myUser.getEmail(), myUser.getAffiliation(), myUser.getWeb_page());
        member.setId(myUser.getId());
        return member;
    }
}
