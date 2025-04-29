package br.ueg.reviewer.service.impl;

import br.ueg.reviewer.entities.Role;
import br.ueg.reviewer.entities.UserGroup;
import br.ueg.reviewer.repository.RoleRepository;
import br.ueg.reviewer.repository.UserGroupRepository;
import br.ueg.genericarchitecture.exception.SecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InitializerService {

    @Value("${initializer.password}")
    private String initializerPassword;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserGroupRepository userGroupRepository;

    public void initializerRoles(String password) {
        if (initializerPassword.equals(password)) {
            List<String> adminRoles = Arrays.asList(
                    "ROLE_USER_CREATE",
                    "ROLE_USER_READ",
                    "ROLE_USER_UPDATE",
                    "ROLE_USER_DELETE",
                    "ROLE_USER_LISTALL",
                    "ROLE_USER_LOG_LISTALL",
                    "ROLE_ITEM_CREATE",
                    "ROLE_ITEM_READ",
                    "ROLE_ITEM_UPDATE",
                    "ROLE_ITEM_DELETE",
                    "ROLE_ITEM_LISTALL",
                    "ROLE_REVIEW_CREATE",
                    "ROLE_REVIEW_READ",
                    "ROLE_REVIEW_UPDATE",
                    "ROLE_REVIEW_DELETE",
                    "ROLE_REVIEW_LISTALL",
                    "ROLE_REVIEW_TABLE_ALL"
            );

            List<String> assistantRoles = Arrays.asList(
                    "ROLE_ITEM_CREATE",
                    "ROLE_ITEM_READ",
                    "ROLE_ITEM_UPDATE"
            );

            List<Role> adminRoleList = new ArrayList<>();
            for (String role : adminRoles) {
                Role userGroupRole = Role.builder().role(role).build();
                adminRoleList.add(userGroupRole);
            }

            List<Role> assistantRoleList = new ArrayList<>();
            for (String role : assistantRoles) {
                Role userGroupRole = Role.builder().role(role).build();
                assistantRoleList.add(userGroupRole);
            }

            UserGroup adminGroup = UserGroup.builder()
                    .name("admin")
                    .roles(adminRoleList)
                    .build();

            UserGroup assistantGroup = UserGroup.builder()
                    .name("assistant")
                    .roles(assistantRoleList)
                    .build();

            roleRepository.saveAll(adminRoleList);
            roleRepository.saveAll(assistantRoleList);
            userGroupRepository.save(adminGroup);
            userGroupRepository.save(assistantGroup);

        } else {
            throw new IllegalArgumentException("Senha inválida");
        }
    }

}
