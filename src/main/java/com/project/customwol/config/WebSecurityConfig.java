package com.project.customwol.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    // WebSecurityConfigurerAdapter 가 없을 때 기본 보안 설정을 한다. 하나 이상 발견되면 설정된 보안 설정을 사용한다.

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /* 권한 확인 하는 부분 */
                .authorizeRequests()
                    .antMatchers("/", "/css/**", "/account/register").permitAll()
                    .anyRequest().authenticated()
                    .and()
                /* 로그인 폼 처리되는 부분 */
                .formLogin()
                    .loginPage("/account/login")
                    .permitAll()
                    .and()
                /* 로그아웃 시 처리 되는 부분 */
                .logout()
                    .permitAll();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select username,password,enabled " // 사용자 정보를 얻기 위한 쿼리
                        + "from user "
                        + "where username = ?")
                .authoritiesByUsernameQuery("select u.username, r.name " // 사용자 권한을 얻기 위한 쿼리
                        + "from user_role ur inner join user u on ur.user_id = u.id "
                        + "inner join role r on ur.role_id = r.id "
                        + "where u.username = ?");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}