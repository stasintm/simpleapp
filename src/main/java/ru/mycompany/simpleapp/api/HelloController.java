package ru.mycompany.simpleapp.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.UUID;

@Slf4j
@RestController
public class HelloController {
    private final RestClient restClient;
    private final String secret;

    public HelloController(@Value("${simpleapp.url}") String baseUrl,
                           @Value("${secret:default}") String secret) {
        restClient = RestClient.builder().baseUrl(baseUrl).build();
        this.secret = secret;
    }

    @GetMapping("api/hello")
    public String greeting() {
        log.info("launch greeting");
        return "Version 1.0.2. Hello!";
    }

    @GetMapping("api/uuid")
    public UUID getUuid() {
        return restClient.get().uri("api/uuid").retrieve().body(UUID.class);
    }

    @GetMapping("api/secret")
    public String showSecret() {
        return secret;
    }

}
