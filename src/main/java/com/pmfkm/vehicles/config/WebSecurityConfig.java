//package com.pmfkm.vehicles.config;
//
//
//
//import javax.annotation.Resource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalAuthentication
//public class WebSecurityConfig  extends WebSecurityConfigurerAdapter  {
//	
////	@Resource(name="userService")
////	private UserDetailsService userDetailsService;
////	
////	@Autowired
////    private JwtAuthenticationEntryPoint unauthorizedHandler;
////	
////	@Override
////    @Bean
////    public AuthenticationManager authenticationManagerBean() throws Exception {
////        return super.authenticationManagerBean();
////    }
////
////    @Autowired
////    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(userDetailsService)
////                .passwordEncoder(encoder());
////    }
////
////    @Bean
////    public JwtAuthenticationFilter authenticationTokenFilterBean() {
////        return new JwtAuthenticationFilter();
////    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.cors().and().csrf().disable().
////                authorizeRequests()
////                .antMatchers("/token/*", "/signup").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////        http
////                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
//    	
//    	
//    	http.authorizeRequests().antMatchers("/*").permitAll();
//    }
//
////    @Bean
////    public BCryptPasswordEncoder encoder(){
////        return new BCryptPasswordEncoder();
////    }
//
//}
