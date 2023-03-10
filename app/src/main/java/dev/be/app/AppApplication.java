package dev.be.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(
    scanBasePackages = {
        "dev.be.app",
        "dev.be.web",
        "dev.be.common",
        "dev.be.domain"
    }
)
@EntityScan("dev.be.domain.entity")
public class AppApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}
