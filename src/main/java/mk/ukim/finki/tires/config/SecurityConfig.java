package mk.ukim.finki.tires.config;

import mk.ukim.finki.tires.authentication.LoginFailureHandler;
import mk.ukim.finki.tires.authentication.LoginSuccessHandler;
import mk.ukim.finki.tires.enums.Provider;
import mk.ukim.finki.tires.enums.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
  prePostEnabled = true,
  securedEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  private final Logger log = LoggerFactory.getLogger(SecurityConfig.class);

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService)
      .passwordEncoder(passwordEncoder());
  }

  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();

//    http.requiresChannel().anyRequest().requiresSecure();

    http.logout()
      .logoutUrl("/logout")
      .deleteCookies("JSESSIONID")
      .permitAll();


    http.formLogin()
      .loginPage("/login")
      .usernameParameter("username")
      .passwordParameter("password")
      .loginProcessingUrl("/doLogin")
      .failureHandler(loginFailureHandler())
      .successHandler(localSuccessHandler())
      .permitAll();


    http.authorizeRequests()
      .antMatchers("/me", "/oauth/authorize", "/oauth/token", "/user")
      .authenticated();

    http.authorizeRequests()
      .antMatchers("/admin/**")
      .hasRole("ADMIN");

    http.authorizeRequests()
      .antMatchers("/**")
      .permitAll();

  }

  @Bean
  public AuthenticationSuccessHandler localSuccessHandler() {
    return new LoginSuccessHandler(
      Provider.LOCAL,
      UserType.ROLE_CUSTOMER
    );
  }


  @Bean
  public AuthenticationFailureHandler loginFailureHandler() {
    return new LoginFailureHandler();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    return encoder;
  }


}
