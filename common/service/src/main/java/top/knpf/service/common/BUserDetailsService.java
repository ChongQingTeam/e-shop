package top.knpf.service.common;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.knpf.model.b.sys.Admin;
import top.knpf.service.b.ISysAdminService;

import java.time.LocalDate;

@Slf4j
@Service
public class BUserDetailsService implements UserDetailsService {

    @Autowired
    ISysAdminService sysAdminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("登录用户：" + username + ",登录时间：" + LocalDate.now());
        Admin queryAdmin = sysAdminService.getAdminByUsername(username);
        if(queryAdmin == null){
            return null;
        }
        UserDetails userDetails =
                User.withUsername(queryAdmin.getUsername()).password(queryAdmin.getPassword()).authorities("p1").build();
        return userDetails;
    }
}
