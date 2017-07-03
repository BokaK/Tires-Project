package mk.ukim.finki.tires.authentication;

import mk.ukim.finki.tires.enums.Provider;
import mk.ukim.finki.tires.models.jpa.User;
import mk.ukim.finki.tires.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFailureHandler implements AuthenticationFailureHandler {
  @Autowired
  private UserRepository userRepository;

  @Override
  public void onAuthenticationFailure(
    HttpServletRequest httpServletRequest,
    HttpServletResponse httpServletResponse,
    AuthenticationException e
  ) throws IOException, ServletException {

    User user = userRepository.findByUsername(
      httpServletRequest.getParameter("username")
    );

    /**
     * If the user is not with local provider, try to authenticate it through
     * its provider
     */
    if (user != null && user.provider != null && user.provider != Provider.LOCAL) {
      httpServletResponse.sendRedirect(user.provider.getLoginUrl());
    }


    httpServletResponse.sendRedirect("/login?error=user not found!");
  }
}
