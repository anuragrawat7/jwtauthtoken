package spring.security.jwtauth.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

//To check the secret key with prefix and secret key in application.properties file
@ConfigurationProperties(prefix = "spring.security.jwtauth")
@Data
public class JwtConfig {

    private Configuration jwt = new Configuration();

    @Data
    public class Configuration {
        private String secretKey;
    }
}
