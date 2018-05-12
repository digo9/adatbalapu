package hu.itguruk.allaskeresoportal.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedMethods("PUT", "DELETE", "POST", "GET", "HEAD", "TRACE", "OPTIONS", "PATCH")
        .allowedHeaders("*");
  }

}
