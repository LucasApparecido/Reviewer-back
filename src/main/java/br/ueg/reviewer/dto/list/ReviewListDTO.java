package br.ueg.reviewer.dto.list;

import br.ueg.reviewer.dto.ImageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewListDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime publicationDate;
    private List<ImageDTO> images;
}
