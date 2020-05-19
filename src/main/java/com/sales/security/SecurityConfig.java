package com.sales.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	// the following helped me get the login done
	// https://stackoverflow.com/questions/61363348/error-the-method-withdefaultpasswordencoder-is-undefined-for-the-type-user-s/61363621?noredirect=1#comment108555775_61363621
	// https://github.com/dmcheremisin/SpringBootSecurity/blob/master/basic.security/src/main/java/org/example/basic/security/config/SecurityConfig.java
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/addCustomer.html", "/addOrder.html", "/addProduct.html", 
					"errorGreaterThanQuantity.html", "errorNoCustProd.html", 
					"/showCustomers.html", "/showOrders.html", "/showProducts.html")
			.authenticated()
			.and().formLogin()
			.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

	// username: user
	// password: user
	@Autowired
	public void ConfigureGlobal(AuthenticationManagerBuilder amb) throws Exception{
		amb.inMemoryAuthentication().withUser("user").password("user").roles("USER");
	}
}