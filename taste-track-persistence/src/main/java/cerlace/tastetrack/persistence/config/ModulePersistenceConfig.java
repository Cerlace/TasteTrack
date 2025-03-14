package cerlace.tastetrack.persistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"cerlace.tastetrack.persistence"})
@EnableJpaRepositories(basePackages={"cerlace.tastetrack.persistence.repository"})
@EntityScan(basePackages={"cerlace.tastetrack.persistence.entity"})
public class ModulePersistenceConfig {
}
