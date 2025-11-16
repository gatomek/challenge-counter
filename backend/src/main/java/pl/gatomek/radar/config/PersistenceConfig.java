package pl.gatomek.radar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "pl.gatomek.radar.repository")
@EnableTransactionManagement
public class PersistenceConfig {

}
