package top.knpf.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    //配置用户信息服务
//    @Bean
//    public UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("admin").password("123456").authorities("p1").build());
//        return manager;
//    }

    //配置安全拦截机制
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/b/test/*").permitAll()
                .antMatchers("/b/login/do").permitAll()
                .anyRequest().authenticated()
//                .and().httpBasic()
                .and().csrf().disable();
//                .formLogin()
//                .successForwardUrl("/b/login/success"); //使用.successForwardUrl() 或者.defaultSuccessUrl() 实现登录成功后的页面跳转
//                .loginPage("/login/")
//                .loginProcessingUrl("/doLogin") //登录处理的URL
//                .successHandler((req, resp, authentication) -> {
//                    Map<String, Object> map = new HashMap<>();
//                    map.put("msg", "登录成功！");
//                    map.put("principal", authentication.getPrincipal());
//                    resp.setContentType("application/json:charset=utf-8");
//                    PrintWriter out = resp.getWriter();
//                    // 对象转json传输给前端
//                    out.write(new ObjectMapper().writeValueAsString(map));
//                    out.flush();
//                    out.close();
//                });
    }

    //配置密码编码器
    @Bean
    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }
    //创建密码
//    public static void main(String[] args) {
//        System.out.println(BCrypt.hashpw("123456", BCrypt.gensalt()));
//    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
