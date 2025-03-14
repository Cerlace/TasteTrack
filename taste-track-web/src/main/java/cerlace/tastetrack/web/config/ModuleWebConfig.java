package cerlace.tastetrack.web.config;

import cerlace.tastetrack.core.config.ModuleCoreConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"cerlace.tastetrack.web"})
@Import(ModuleCoreConfig.class)
public class ModuleWebConfig {
}
