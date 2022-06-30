package br.com.java.sistemacontrolecarros.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.java.sistemacontrolecarros.service.UserDetailService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDetailService userDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub
        auth
        .userDetailsService(userDetailService)
        .passwordEncoder(bCryptPasswordEncoder);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        String loginPage = "/login";
        String logoutPage = "/logout";
        http
        .authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers(loginPage).permitAll()
        .antMatchers("/registration").permitAll()
        // .antMatchers("/admin/**").hasAuthority("ADMIN")
        .antMatchers("/admin/**").permitAll()
        .anyRequest()
        .authenticated()
        .and().csrf().disable()
        .formLogin()
        .loginPage(loginPage)
        .loginPage("/")
        .failureUrl("/login?error=true")
        .defaultSuccessUrl("/admin/home")
        .usernameParameter("user_name")
        .passwordParameter("password")
        .and().logout()
        .logoutRequestMatcher(new AntPathRequestMatcher(logoutPage))
        .logoutSuccessUrl(loginPage).and().exceptionHandling();
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        // TODO Auto-generated method stub
        super.configure(web);
        web
        .ignoring()
        .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**" );
    }
}
