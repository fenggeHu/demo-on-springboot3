package admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @author max.hu  @date 2023/11/29
 **/
//@EnableWebFlux
@EnableAutoConfiguration
@EnableConfigurationProperties
//@MapperScan({"tibet", "security"})
@SpringBootApplication (scanBasePackages = {"admin"})
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }


}
