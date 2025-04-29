package br.ueg.reviewer.service.validations.user;

import br.ueg.reviewer.entities.User;
import br.ueg.reviewer.enums.ErrorEnum;
import br.ueg.genericarchitecture.enums.ValidationActionsEnum;
import br.ueg.genericarchitecture.exception.Message;
import br.ueg.genericarchitecture.validation.IValidations;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMandatoryFields implements IValidations<User> {
    @Override
    public void validate(User data, ValidationActionsEnum action, List<Message> messagesToThrow) {
        if (data.getName() == null || data.getName().isEmpty()) {
            messagesToThrow.add(new Message(ErrorEnum.MANDATORY_FIELD, "'nome'"));
        }
        if (data.getEmail() == null || data.getEmail().isEmpty()) {
            messagesToThrow.add(new Message(ErrorEnum.MANDATORY_FIELD, "'email'"));
        }
    }
}
