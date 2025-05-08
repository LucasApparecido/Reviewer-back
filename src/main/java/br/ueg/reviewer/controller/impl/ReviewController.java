package br.ueg.reviewer.controller.impl;

import br.ueg.genericarchitecture.controller.impl.AbstractCrudController;
import br.ueg.reviewer.controller.IReviewController;
import br.ueg.reviewer.dto.list.ReviewListDTO;
import br.ueg.reviewer.dto.request.ReviewRequestDTO;
import br.ueg.reviewer.dto.response.ReviewResponseDTO;
import br.ueg.reviewer.entities.Review;
import br.ueg.reviewer.mapper.ReviewMapper;
import br.ueg.reviewer.service.IReviewService;
import br.ueg.reviewer.service.impl.ReviewService;
import br.ueg.genericarchitecture.controller.impl.AbstractCrudFileController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.version}/review")
public class ReviewController extends AbstractCrudController<
        ReviewRequestDTO, ReviewResponseDTO, ReviewListDTO, Review, ReviewService, ReviewMapper, Long>
        implements IReviewController {

    @Autowired
    protected IReviewService service;
    @Autowired
    protected ReviewMapper mapper;

    @GetMapping(path = {"view/{id}"})
    public ResponseEntity<ReviewResponseDTO> viewReview(@PathVariable Long id) {
        ReviewResponseDTO dtoResult = this.mapper.toDTO(this.service.getById(id));
        return ResponseEntity.ok(dtoResult);
    }
}
