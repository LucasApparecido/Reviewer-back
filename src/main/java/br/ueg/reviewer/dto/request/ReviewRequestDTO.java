package br.ueg.reviewer.dto.request;

import br.ueg.genericarchitecture.annotation.MandatoryField;
import br.ueg.genericarchitecture.dto.DTOFile;
import br.ueg.genericarchitecture.dto.FileDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDTO implements DTOFile {
    private Long id;

    @MandatoryField(name = "título")
    private String title;

    @MandatoryField(name = "conteúdo", length = 10000)
    private String content;


    @MandatoryField(name = "imagem(ns)")
    private List<FileDTO> files;
}
