package br.ueg.reviewer.mapper;

import br.ueg.reviewer.dto.ImageDTO;
import br.ueg.reviewer.entities.ReviewImage;
import br.ueg.genericarchitecture.dto.FileDTO;
import org.mapstruct.*;

import java.util.Base64;
import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ReviewImageMapper {
    @Mapping(source = "file", target = "image")
    ReviewImage toModel(FileDTO fileDTO);

    @Named(value = "toDTO")
    default ImageDTO toDTO(ReviewImage model) {

        return ImageDTO.builder()
                .id(model.getId())
                .image(Base64.getEncoder().encodeToString(model.getImage()))
                .build();
    }

    @IterableMapping(qualifiedByName = "toDTO")
    List<ImageDTO> fromModelToDTOList(List<ReviewImage> ReviewImage);
}