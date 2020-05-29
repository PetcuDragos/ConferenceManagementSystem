package ro;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ro.config.CacheConfig;
import ro.config.JPAConfig;


@Configuration
@ComponentScan(value = {"ro"},
        excludeFilters = {@ComponentScan.Filter(value = {JPAConfig.class, CacheConfig.class}, type = FilterType.ASSIGNABLE_TYPE)})
@Import({JPAConfigIT.class})
@PropertySources({@PropertySource(value = "classpath:db-h2.properties")})
public class ITConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
