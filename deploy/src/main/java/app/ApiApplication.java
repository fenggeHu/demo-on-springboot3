package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @author max.hu  @date 2023/12/04
 **/
@EnableWebFlux      // 可切换模式
@SpringBootApplication(scanBasePackages = {"api"})
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
