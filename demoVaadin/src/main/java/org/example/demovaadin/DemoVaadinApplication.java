package org.example.demovaadin;

import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.example.demovaadin.UI.LoginView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//class extends VaadinWebSecurity, which is a helper class provided by Vaadin
// to integrate Vaadin applications with Spring Security
@SpringBootApplication
public class DemoVaadinApplication extends VaadinWebSecurity {

//	starting the embedded server and initializing Spring components
	public static void main(String[] args) {
		SpringApplication.run(DemoVaadinApplication.class, args);
	}

//	here, use Spring Security for authentication
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		call sets up the default configurations provided by VaadinWebSecurity
		super.configure(http);
//		specifies the LoginView class as the login page for the application
		setLoginView(http, LoginView.class);
	}

//	used by Spring Security to load user-specific data
//	@Bean
//	public UserDetailsService userDetailsServiceBean() throws Exception {
////		used to store user details in memory
//		return new InMemoryUserDetailsManager(
////				{noop} prefix indicates that the passwords are stored in plain text and no encoding is applied
//				User.withUsername("tnj")
//						.password("{noop}password")
//						.roles("ADMIN")
//						.build(),
//				User.withUsername("Maria")
//						.password("{noop}p")
//						.roles("ADMIN")
//						.build()
//		);
//	}

	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return new InMemoryUserDetailsManager(
				User.withUsername("tnj")
						.password("{noop}password")
						.roles("ADMIN")
						.build(),
				User.withUsername("Maria")
						.password("{noop}p")
						.roles("ADMIN")
						.build()
		);
	}

}
