package br.ueg.reviewer.dto.response;

import br.ueg.reviewer.entities.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String name;
    private String login;
    private String email;
    private UserGroup userGroup;
    private Boolean enabled;
}
