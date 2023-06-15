package br.dev.jstec.learn.resources.dto;

import br.dev.jstec.learn.resources.exceptions.validation.UserUpdateValid;
import lombok.Data;

@Data
@UserUpdateValid
public class UserUpdateDTO extends UserDTO{
    public UserUpdateDTO() {
        super();
    }
}
