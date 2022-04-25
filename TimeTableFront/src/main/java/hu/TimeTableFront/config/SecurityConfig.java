package hu.TimeTableFront.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth){
        try {
            auth.inMemoryAuthentication()
                    .withUser("Administrator").password("$2a$10$DjI.P92vFenHcKMQBb1nKeHqmOnsL/y/6vX4Dcr4Nxl0JO5UaV5xG").roles("USER", "ADMIN")
                    .and()
                    .withUser("71123567012").password("$2a$10$DjI.P92vFenHcKMQBb1nKeHqmOnsL/y/6vX4Dcr4Nxl0JO5UaV5xG").roles("TEACHER");
        } catch (Exception ex) {
            System.out.println("ex in configureAuth(): "+ex.getMessage());
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/c-students","/c-teachers","/c-addteacher","/c-classrooms","/c-subjects" ,"/c-studentclasses","/c-teachersubjectlist/**","/c-studentlists/**","/c-timetablelists/**/**", "/pics/**", "/css/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/teacherhome/**", "**/css/**").hasRole("TEACHER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll();
    }
}
