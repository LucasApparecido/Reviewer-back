package br.ueg.reviewer.service;

import br.ueg.reviewer.dto.request.UserRequestDTO;
import br.ueg.reviewer.entities.User;
import br.ueg.reviewer.entities.UserLog;
import br.ueg.genericarchitecture.service.IAbstractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService extends IAbstractService<UserRequestDTO, User, Long> {
    boolean isUserEnabled(Long userId);
    void toggleUserAccess(Long userId, boolean enable);
    Page<UserLog> getLogUsers(Pageable pageable);
}
