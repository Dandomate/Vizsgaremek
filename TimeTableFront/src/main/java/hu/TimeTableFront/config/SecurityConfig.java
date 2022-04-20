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
                    .withUser("jacky").password("$2a$10$DjI.P92vFenHcKMQBb1nKeHqmOnsL/y/6vX4Dcr4Nxl0JO5UaV5xG").roles("USER", "ADMIN")
                    .and()
                    .withUser("jane").password("$2a$10$DjI.P92vFenHcKMQBb1nKeHqmOnsL/y/6vX4Dcr4Nxl0JO5UaV5xG").roles("TEACHER");
        } catch (Exception ex) {
            System.out.println("ex in configureAuth(): "+ex.getMessage());
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.csrf().disable();
        // mert a POST új horgász 403-as hibát dob
        // https://stackoverflow.com/questions/50486314/how-to-solve-403-error-in-spring-boot-post-request
        // de akkor a log out nem kér megerősítést és azonnal kilép
        // ugyanott lentebb írtak egy jobb megoldást: az űrlapban az action attribútum ez legyen: @{url}
        http.authorizeRequests()
                .antMatchers("/", "/c-students","/c-teachers","/c-addteacher","/c-classrooms","/c-subjects" ,"/c-studentclasses","/c-teachersubjectlist/**","/c-studentlists/**","/c-timetablelists/**/**", "/pics/**", "/css/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/teacherview/**").hasRole("TEACHER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll();
    }
}
