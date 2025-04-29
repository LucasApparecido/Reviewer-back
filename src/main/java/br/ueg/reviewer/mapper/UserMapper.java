package br.ueg.reviewer.mapper;

import br.ueg.reviewer.dto.list.UserListDTO;
import br.ueg.reviewer.dto.request.UserRequestDTO;
import br.ueg.reviewer.dto.response.UserResponseDTO;
import br.ueg.reviewer.entities.User;
import br.ueg.genericarchitecture.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserMapper extends GenericMapper<UserRequestDTO, UserResponseDTO, UserListDTO, User, Long> {
}
