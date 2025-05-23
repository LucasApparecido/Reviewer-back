package br.ueg.reviewer.service.impl;

import br.ueg.reviewer.entities.UserGroup;
import br.ueg.reviewer.repository.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupService {

    @Autowired
    private UserGroupRepository userGroupRepository;

    public List<UserGroup> findAll() {
        return userGroupRepository.findAll();
    }

}