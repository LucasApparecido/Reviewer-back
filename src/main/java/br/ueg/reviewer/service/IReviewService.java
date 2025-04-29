package br.ueg.reviewer.service;

import br.ueg.reviewer.dto.request.ReviewRequestDTO;
import br.ueg.reviewer.entities.Review;
import br.ueg.genericarchitecture.service.IAbstractService;

public interface IReviewService extends IAbstractService<ReviewRequestDTO, Review, Long> {
}
