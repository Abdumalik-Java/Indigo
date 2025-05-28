package abdumalik.dev.indigo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.UUID;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public AuthenticationProvider authenticationProvider() {
        String password = UUID.randomUUID().toString();
        System.out.println("                ---------------------------User Password -----------------------> " + password);

        UserDetails user = User.builder()
                .username("user")
                .password("{noop}" + password)
                .roles("USER")
                .build();

        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(new InMemoryUserDetailsManager(user));
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
            authorizationManagerRequestMatcherRegistry

                    .requestMatchers(HttpMethod.OPTIONS, "/account", "/account/*").permitAll()
                    .requestMatchers(HttpMethod.OPTIONS, "/address", "/address/*").permitAll()
                    .requestMatchers(HttpMethod.OPTIONS, "/document", "/document/*").permitAll()
                    .requestMatchers(HttpMethod.OPTIONS, "/file", "/file/*").permitAll()
                    .requestMatchers(HttpMethod.OPTIONS, "/form", "/form/*").permitAll()
                    .requestMatchers(HttpMethod.OPTIONS, "/photo", "/photo/*").permitAll()
                    .requestMatchers(HttpMethod.OPTIONS, "/profile", "/profile/*").permitAll()
                    .requestMatchers(HttpMethod.OPTIONS, "/profileKids", "/profileKids/*").permitAll()
                    .requestMatchers(HttpMethod.OPTIONS, "/relative", "/relative/*").permitAll()
                    .requestMatchers(HttpMethod.OPTIONS, "/report", "/report/*").permitAll()
                    .requestMatchers(HttpMethod.OPTIONS, "/statistics", "/statistics/*").permitAll()
                    .requestMatchers(HttpMethod.OPTIONS, "/task", "/task/*").permitAll()
                    .requestMatchers(HttpMethod.OPTIONS, "/template", "/template/*").permitAll()
                    .requestMatchers(HttpMethod.OPTIONS, "/transferBaby", "/transferBaby/*").permitAll()
                    .requestMatchers(HttpMethod.OPTIONS, "/workInfo", "/workInfo/*").permitAll()
                    .requestMatchers(HttpMethod.OPTIONS, "/register", "/register/*").permitAll()
                    // group class
                    .requestMatchers(HttpMethod.GET, "/group", "/group/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/group").hasAnyRole("SUPERADMIN", "ADMIN", "TEACHER", "SUPERVISOR", "DEPUTY_HEAD")
                    .requestMatchers(HttpMethod.PUT, "/group/*").hasAnyRole("SUPERADMIN", "ADMIN", "TEACHER", "SUPERVISOR", "DEPUTY_HEAD")
                    .requestMatchers(HttpMethod.DELETE, "/group/*").hasAnyRole("SUPERADMIN", "ADMIN", "TEACHER", "SUPERVISOR", "DEPUTY_HEAD")
                    // employees class
                    .requestMatchers(HttpMethod.GET, "/employees", "/employees/*").hasAnyRole("SUPERADMIN", "ADMIN", "TEACHER", "SUPERVISOR", "DEPUTY_HEAD")
                    .requestMatchers(HttpMethod.POST, "/employees").hasAnyRole("SUPERADMIN", "ADMIN", "TEACHER", "SUPERVISOR", "DEPUTY_HEAD")
                    .requestMatchers(HttpMethod.PUT, "/employees/*").hasAnyRole("SUPERADMIN", "ADMIN", "TEACHER", "SUPERVISOR", "DEPUTY_HEAD")
                    .requestMatchers(HttpMethod.DELETE, "/employees/*").hasAnyRole("SUPERADMIN", "ADMIN", "TEACHER", "SUPERVISOR", "DEPUTY_HEAD")
                    // action class
                    .requestMatchers(HttpMethod.GET, "/action", "/action/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/action").hasAnyRole("SUPERADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/action/*").hasAnyRole("SUPERADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/action/*").hasAnyRole("SUPERADMIN","ADMIN")
                    // carService class
                    .requestMatchers(HttpMethod.GET, "/carService", "/carService/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/carService").hasAnyRole("SUPERADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/carService/*").hasAnyRole("SUPERADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/carService/*").hasAnyRole("SUPERADMIN","ADMIN")
                    // attendanceStatistics class
                    .requestMatchers(HttpMethod.GET, "/attendanceStatistics", "/attendanceStatistics/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/attendanceStatistics").hasAnyRole("SUPERADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/attendanceStatistics/*").hasAnyRole("SUPERADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/attendanceStatistics/*").hasAnyRole("SUPERADMIN","ADMIN")
                    // calendar class
                    .requestMatchers(HttpMethod.GET, "/calendar", "/calendar/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/calendar").hasAnyRole("SUPERADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/calendar/*").hasAnyRole("SUPERADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/calendar/*").hasAnyRole("SUPERADMIN","ADMIN")
                    // category class
                    .requestMatchers(HttpMethod.GET, "/category", "/category/*").hasAnyRole("SUPERADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.POST, "/category").hasAnyRole("SUPERADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/category/*").hasAnyRole("SUPERADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/category/*").hasAnyRole("SUPERADMIN","ADMIN")
                    // categoryMenu class
                    .requestMatchers(HttpMethod.GET, "/categoryMenu", "/categoryMenu/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/categoryMenu").hasAnyRole("SUPERADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/categoryMenu/*").hasAnyRole("SUPERADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/categoryMenu/*").hasAnyRole("SUPERADMIN","ADMIN")
                    // categoryQuartal class
                    .requestMatchers(HttpMethod.GET, "/categoryQuartal", "/categoryQuartal/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/categoryQuartal").hasAnyRole("SUPERADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/categoryQuartal/*").hasAnyRole("SUPERADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/categoryQuartal/*").hasAnyRole("SUPERADMIN","ADMIN")
                    // check class
                    .requestMatchers(HttpMethod.GET, "/check", "/check/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/check").hasAnyRole("SUPERADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/check/*").hasAnyRole("SUPERADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/check/*").hasAnyRole("SUPERADMIN","ADMIN")
                    // icon class
                    .requestMatchers(HttpMethod.GET, "/icon", "/icon/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/icon").hasAnyRole("SUPERADMIN", "ADMIN", "TEACHER", "SUPERVISOR", "DEPUTY_HEAD")
                    .requestMatchers(HttpMethod.PUT, "/icon/*").hasAnyRole("SUPERADMIN", "ADMIN", "TEACHER", "SUPERVISOR", "DEPUTY_HEAD")
                    .requestMatchers(HttpMethod.DELETE, "/icon/*").hasAnyRole("SUPERADMIN", "ADMIN", "TEACHER", "SUPERVISOR", "DEPUTY_HEAD")
                    // menu class
                    .requestMatchers(HttpMethod.GET, "/menu", "/menu/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/menu").hasAnyRole("SUPERADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/menu/*").hasAnyRole("SUPERADMIN", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/menu/*").hasAnyRole("SUPERADMIN","ADMIN")
                    // planDay class
                    .requestMatchers(HttpMethod.GET, "/planDay", "/planDay/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "/planDay").hasAnyRole("SUPERADMIN", "ADMIN", "TEACHER", "SUPERVISOR", "DEPUTY_HEAD")
                    .requestMatchers(HttpMethod.PUT, "/planDay/*").hasAnyRole("SUPERADMIN", "ADMIN", "TEACHER", "SUPERVISOR", "DEPUTY_HEAD")
                    .requestMatchers(HttpMethod.DELETE, "/planDay/*").hasAnyRole("SUPERADMIN", "ADMIN", "TEACHER", "SUPERVISOR", "DEPUTY_HEAD")


                    .anyRequest()
                    .authenticated();
        }).formLogin(Customizer.withDefaults());

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.ignoringRequestMatchers("/api/**"));
        http.cors(cors -> cors.configurationSource(request -> {
            var config = new org.springframework.web.cors.CorsConfiguration();
            config.setAllowedOrigins(List.of("https://your-frontend.com")); // frontend domain
            config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
            config.setAllowedHeaders(List.of("*"));
            return config;
        }));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                String md5 = MD5Util.getMD5(rawPassword.toString());
                return md5.equals(encodedPassword);
            }
        };

    }

}