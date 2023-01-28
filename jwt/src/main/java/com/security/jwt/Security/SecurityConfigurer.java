package com.security.jwt.Security;

import com.security.jwt.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfigurer implements WebSecurityConfigurer {

@Bean
  public  PasswordEncoder passwordEncoder(){
       return NoOpPasswordEncoder.getInstance();
   }



    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable();
    }

    @Override
    public void init(SecurityBuilder builder) throws Exception {
        System.out.println("init: "+builder);
    }

    @Override
    public void configure(SecurityBuilder builder) throws Exception {
          System.out.println("configure: "+builder);
    }
}
