package br.dev.jstec.learn.resources.dto;

import br.dev.jstec.learn.resources.exceptions.validation.UserInsertValid;
import lombok.Data;

@Data
@UserInsertValid
public class UserInsertDTO extends UserDTO{
    private String password;

    public UserInsertDTO() {
        super();
    }
}
