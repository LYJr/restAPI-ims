package ims;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);

        registry.addViewController("/login").setViewName("user/login");
        registry.addViewController("/join").setViewName("user/join");

        registry.addViewController("/issue/form").setViewName("issue/form");

        registry.addViewController("/milestone").setViewName("milestone/list");

    }
}

