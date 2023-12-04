package swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * swagger v3 - open api
 * @author max.hu  @date 2023/12/04
 **/
@Configuration
public class Swagger3Config {

    @Bean
    public OpenAPI openAPI(Swagger3Properties prop) {
        return new OpenAPI()
                .info(new Info().title(prop.getTitle())
                        .description(prop.getDescription())
                        .version(prop.getVersion())
                        .license(prop.getLicense()))
                .externalDocs(prop.getExternalDocs());
    }
}
