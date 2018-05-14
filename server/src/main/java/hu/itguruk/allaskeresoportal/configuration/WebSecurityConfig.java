package hu.itguruk.allaskeresoportal.configuration;

import hu.itguruk.allaskeresoportal.service.UserServiceImpl;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserServiceImpl userService;

  @Autowired
  private DataSource dataSource;

  private static final String USERS_QUERY = "SELECT felhasznalonev, jelszo, engedelyezve FROM felhasznalo where felhasznalonev=?";
  private static final String AUTHORITIES_QUERY = "select felhasznalonev, label from felhasznalo, app_role_felhasznalo, APP_ROLE where felhasznalo.id = app_role_felhasznalo.felhasznalo_ID and felhasznalo.felhasznalonev = ? group by label,felhasznalonev";



  private static final String SECURE_URL = "/secure";
  private static final String LOGIN_URL = "/login";
  private static final String LOGOUT_URL = "/logout";
  private static final String ERROR_PAGE_URL = "/errorPage";
  private static final String H2_CONSOLE_URL = "/console";


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.exceptionHandling().defaultAuthenticationEntryPointFor(getRestAuthenticationEntryPoint(),
        new AntPathRequestMatcher("**"));
    // @formatter:off
    http.csrf().disable()
        .cors().and().authorizeRequests();
    http.authorizeRequests().antMatchers(HttpMethod.GET, H2_CONSOLE_URL).permitAll()
        .and().formLogin().loginPage(ERROR_PAGE_URL).loginProcessingUrl(LOGIN_URL).successForwardUrl(SECURE_URL).failureForwardUrl(ERROR_PAGE_URL)
        .and().logout().logoutUrl(LOGOUT_URL).logoutSuccessHandler((new HttpStatusReturningLogoutSuccessHandler(HttpStatus.NO_CONTENT)));

    http.headers().frameOptions().disable();
    // @formatter:on
  }

  private AuthenticationEntryPoint getRestAuthenticationEntryPoint() {
    return new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED);
  }

  @Autowired
  protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery(USERS_QUERY)
        .authoritiesByUsernameQuery(AUTHORITIES_QUERY);
//    auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
  }

  @Override
  public void configure(WebSecurity webSecurity) {
    webSecurity.ignoring().antMatchers(H2_CONSOLE_URL);
  }

}
