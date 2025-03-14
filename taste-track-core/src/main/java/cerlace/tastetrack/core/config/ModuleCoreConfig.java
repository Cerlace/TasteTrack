package cerlace.tastetrack.core.config;

import cerlace.tastetrack.persistence.config.ModulePersistenceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"cerlace.tastetrack.core"})
@Import(ModulePersistenceConfig.class)
public class ModuleCoreConfig {
}
