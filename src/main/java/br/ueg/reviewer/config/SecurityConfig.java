package br.ueg.reviewer.config;

import br.ueg.genericarchitecture.config.ApiSecurityConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig extends ApiSecurityConfig {

    @Value("${api.version}")
    private String apiBase;

    @Override
    protected void configureHttpSecurity(HttpSecurity http) throws Exception {

    }

    @Override
    protected List<String> getCustomFreeAccess() {
        List<String> urls = new ArrayList<>();
        urls.add(apiBase.concat("/review/list"));
        urls.add(apiBase.concat("/item/list"));
        urls.add(apiBase.concat("/item/search/**"));
        urls.add(apiBase.concat("/item/view/**"));
        urls.add(apiBase.concat("/item/pdf"));
        urls.add(apiBase.concat("/review/search/**"));
        urls.add(apiBase.concat("/review/view/**"));
        return urls;
    }

    @Override
    protected List<String> getCustomFreeAccessGet() {
        return List.of();
    }
}
