package br.ueg.reviewer.service.impl;

import br.ueg.reviewer.dto.list.ReviewListDTO;
import br.ueg.reviewer.dto.request.ReviewRequestDTO;
import br.ueg.reviewer.dto.response.ReviewResponseDTO;
import br.ueg.reviewer.entities.Review;
import br.ueg.reviewer.entities.ReviewImage;
import br.ueg.reviewer.entities.User;
import br.ueg.reviewer.mapper.ReviewMapper;
import br.ueg.reviewer.repository.ReviewRepository;
import br.ueg.reviewer.service.IReviewService;
import br.ueg.genericarchitecture.dto.CredentialDTO;
import br.ueg.genericarchitecture.security.impl.CredentialProvider;
import br.ueg.genericarchitecture.service.impl.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService extends AbstractService<ReviewRequestDTO, ReviewResponseDTO, ReviewListDTO, Review, ReviewRepository, ReviewMapper, Long>
        implements IReviewService {

    @Autowired
    private ReviewRepository repository;

    @Override
    protected void prepareToCreate(Review data) {
        setUserAndPublicationDate(data);
    }

    @Override
    protected void prepareToUpdate(Review data) {
        setUserAndPublicationDate(data);
    }

    @Override
    protected void prepareToDelete(Review data) {
    }

    protected void setUserAndPublicationDate(Review data) {
        User user = new User();
        user.setId(((CredentialDTO) CredentialProvider.newInstance().getCurrentInstance()).getId());
        data.setUser(user);
    }
}
