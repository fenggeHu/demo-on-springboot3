package swagger;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.License;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *  补充new OpenAPI配置
 * @author max.hu  @Date 2021-12-24
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "springdoc.openapi")
public class Swagger3Properties {
    private String title;
    private String description;
    private String version;

    private License license;
    private ExternalDocumentation externalDocs;
}
