package top.knpf.service.common;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class BUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("登录用户：" + username + ",登录时间：" + LocalDate.now());
        UserDetails userDetails = User.withUsername("admin").password("$2a$10$xk.8KkSOZRKzhsFVPWz9IOGHnAplWc8JMjKwb7lxi21MpTP51UVou").authorities("p1").build();
        return userDetails;
    }
}
