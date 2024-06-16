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

@SpringBootApplication
public class DemoVaadinApplication extends VaadinWebSecurity {

	public static void main(String[] args) {
		SpringApplication.run(DemoVaadinApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		setLoginView(LoginView.class);
	}

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
