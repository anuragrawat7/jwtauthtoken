package spring.security.jwtauth.requestDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
@ToString
public class UserRequestDTO {

    private String emailId;

    private String password;
}
