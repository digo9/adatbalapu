package hu.itguruk.allaskeresoportal.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  // This method is used for override HttpSecurity of the web Application.
  // We can specify our authorization criteria inside this method.
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and()
        // starts authorizing configurations
        .authorizeRequests()
        // ignoring the guest's urls "
        .antMatchers("/account/register","/account/login","/logout","/**").permitAll()
        // authenticate all remaining URLS
        .anyRequest().fullyAuthenticated().and()
        /* "/logout" will log the user out by invalidating the HTTP Session,
         * cleaning up any {link rememberMe()} authentication that was configured, */
        .logout()
        .permitAll()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
        .and()
        // enabling the basic authentication
        .httpBasic().and()
        // configuring the session on the server
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and()
        // disabling the CSRF - Cross Site Request Forgery
        .csrf().disable();
  }




}
