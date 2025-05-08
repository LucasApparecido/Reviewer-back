package br.ueg.reviewer.service.validations.review;

import br.ueg.reviewer.entities.Review;
import br.ueg.reviewer.entities.ReviewImage;
import br.ueg.reviewer.enums.ErrorEnum;
import br.ueg.genericarchitecture.enums.ValidationActionsEnum;
import br.ueg.genericarchitecture.exception.Message;
import br.ueg.genericarchitecture.validation.IValidations;

import java.util.List;

public class ReviewImageValidate implements IValidations<Review> {
    @Override
    public void validate(Review data, ValidationActionsEnum action, List<Message> messagesToThrow) {
    }
}