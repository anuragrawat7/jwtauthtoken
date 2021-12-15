package spring.security.jwtauth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Jacksonized
@ToString
@AllArgsConstructor
public class UserResponseDTO {

    private UUID uuid;

    private String emailId;

    private Date createdAt;
}
