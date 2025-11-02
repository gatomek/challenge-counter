package pl.gatomek.counter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "pl.gatomek.counter.repository")
@EnableTransactionManagement
public class PersistenceConfig {

}
