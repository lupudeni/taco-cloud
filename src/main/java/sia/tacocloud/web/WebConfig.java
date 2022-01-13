package sia.tacocloud.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sia.tacocloud.util.Path;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //* WebMvcConfigurer defines many methods that are used to configure the MVC. Only override what you need
    //* any configuration class (including @SpringBootApplication) can implement WebMvcConfigurer and override these methods
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName(Path.HOME);
        //*  registry.addViewController("/") returns a ViewControllerRegistration Object. / is the path for which we want to
        //* activate this view controller. (it only gets stuff)
        //* .setViewName(Path.HOME) we set the name of the html view where you will be redirected on /
        //* this creates a view only controller for the homepage. no need to a HomeController anymore
    }
}
