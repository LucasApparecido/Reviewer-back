package br.ueg.reviewer.mapper;

import br.ueg.reviewer.dto.list.ReviewListDTO;
import br.ueg.reviewer.dto.request.ReviewRequestDTO;
import br.ueg.reviewer.dto.response.ReviewResponseDTO;
import br.ueg.reviewer.entities.Review;
import br.ueg.genericarchitecture.mapper.GenericMapper;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {ReviewImageMapper.class}
)
public interface ReviewMapper extends GenericMapper<ReviewRequestDTO, ReviewResponseDTO, ReviewListDTO, Review, Long> {

}
