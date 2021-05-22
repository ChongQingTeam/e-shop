package top.knpf.api_b.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.knpf.domain.b.input.BLoginFormParam;
import top.knpf.domain.b.output.BaseResult;
import top.knpf.security.utils.SecurityUtils;
import top.knpf.utils.security.AESUtils;
import top.knpf.utils.security.TokenUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/b/login")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/do")
    public BaseResult<String> login(@RequestBody BLoginFormParam param,
                                    HttpServletResponse response, HttpServletRequest request)  {
        BaseResult<String> baseResult = new BaseResult<>();
        try{
            String desPwd = AESUtils.decrypt(param.getPassword());
            User user = SecurityUtils.login(param.getUsername(), desPwd, authenticationManager);
            if(user != null){
                String token = TokenUtils.buildJWT(param.getUsername());
                Cookie addcookie = new Cookie("token", token);
                addcookie.setPath("/");
                addcookie.setMaxAge(-3600 * 24);//设置cookie已过期一天
                addcookie.setVersion(1);
                String host=request.getHeader("host");
                if(host.indexOf(":")>-1){
                    host=host.split(":")[0];
                }
                addcookie.setDomain(host);
                response.addCookie(addcookie);
                return baseResult.renderSuccess("登录成功","200", token);
            }
        }catch (Exception e){
            return baseResult.renderError("登陆失败:" + e.getMessage(),"401");
        }
        return baseResult.renderError("登陆失败","401");
    }

}
