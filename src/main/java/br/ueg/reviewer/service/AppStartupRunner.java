package br.ueg.reviewer.service;

import br.ueg.reviewer.entities.*;
import br.ueg.reviewer.repository.ReviewRepository;
import br.ueg.reviewer.repository.UserGroupRepository;
import br.ueg.reviewer.repository.UserRepository;
import br.ueg.reviewer.service.impl.InitializerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AppStartupRunner implements ApplicationRunner {
    public static final String NONE = "none";
    public static final String CREATE_DROP = "create-drop";
    public static final String CREATE = "create";
    public static final String UPDATE = "update";

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;
    @Value("${initializer.password}")
    private String initializerPassword;

    private static final Logger LOG = LoggerFactory.getLogger(AppStartupRunner.class);

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserGroupRepository userGroupRepository;
    @Autowired
    private InitializerService initializerService;

    public void initDados() {

        LOG.info("Iniciando a execução do método initDados()");
        if(!ddlAuto.equals(CREATE) && !ddlAuto.equals(CREATE_DROP)) {
            return;
        }

        initializerService.initializerRoles(initializerPassword);

        UserGroup userGroup = userGroupRepository.findByName("admin");


        User user = null;
        user = User.builder()
                .id(1L)
                .email("teste@gmail.com")
                .enabled(Boolean.TRUE)
                .userGroup(userGroup)
                .login("admin")
                .name("Administrador")
                .password("$2y$10$1MgdNcIduZBhvlTym.PKje0nDX54UVS28jTa2U3lB3JvrqAj4fAdq") // Senha == admin
                .build();
        this.userRepository.save(user);

        Review review = null;
        review = Review.builder()
                .content("Postagem de teste")
                .title("Título Teste")
                .publicationDate(LocalDateTime.now())
                .user(user)
                .build();
        this.reviewRepository.save(review);
        LOG.info("Finalizando a execução do método initDados()");
    }

    public void run(ApplicationArguments args) throws Exception {
        try {
                this.initDados();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
